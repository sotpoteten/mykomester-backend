package no.ntnu.isaksj.backend.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import no.ntnu.isaksj.backend.enums.Normliststatus;
import no.ntnu.isaksj.backend.model.Picture;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.service.PictureService;
import no.ntnu.isaksj.backend.service.SpeciesService;

@RestController
public class SpeciesController {
    
    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private PictureService pictureService;

    Logger logger = LoggerFactory.getLogger(SpeciesController.class);

    @PostMapping("add_species_json")
    public ResponseEntity<String> addSpeciesFromJson(@RequestBody Object[] object) {
        JSONArray jsonArray = new JSONArray(object);

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject shroom = jsonArray.getJSONObject(i);

            if (!checkForDuplicate(shroom.getString("latinsknavn"))) {
                Species newSpecies = new Species();
                newSpecies.setName(shroom.getString("norsknavn") + " (" + shroom.getString("latinsknavn") + ")");
                newSpecies.setCategory(Normliststatus.getStatusFromString(shroom.getString("normstatus")));
                try {
                    newSpecies.setNote(shroom.getString("kommentar"));
                } catch (JSONException e) {
                    // No comment set for current species. Continue execution.
                }
                speciesService.updateSpecies(newSpecies);
            }            
        }

        return new ResponseEntity<>("Lagt til nye arter i databasen", HttpStatus.OK);
    }

    @GetMapping("/update_species_pictures")
    public ResponseEntity<String> updateSpeciesPictures() {
        pictureService.deleteAll();
        List<Species> allSpecies = speciesService.findAll();
        List<String> failedSpecies = new ArrayList<>();
        
        for (Species s : allSpecies) {
            int id = getScientificId(s);
            if (id == -1) {
                failedSpecies.add(s.getName());
            } else {
                if (!addPictureUrls(s, id)) {
                    failedSpecies.add(s.getName());
                }
            }
        }

        String fails = "";
        for (String s : failedSpecies) {
            fails += s + ", ";
        }

        return new ResponseEntity<>("Bildene i databasen oppdatert foruten følgende arter: " + fails, HttpStatus.OK);
    }

    public int getScientificId(Species species) {
        String uri = "https://artskart.artsdatabanken.no/publicapi/api/taxon?term=" + species.getName() + "&taxonGroups=9";
        RestTemplate restTemplate = new RestTemplate();
        Object[] response = restTemplate.getForObject(uri, Object[].class);
        JSONArray array = new JSONArray(response);
        int r = -1;
        try {
            r = array.getJSONObject(0).getInt("ValidScientificNameId");
        } catch (JSONException e1) {
            String fullName = species.getName();
            String scientificName = fullName.substring(fullName.indexOf("(")+1, fullName.indexOf(")"));
            uri = "https://artskart.artsdatabanken.no/publicapi/api/taxon?term=" + scientificName + "&taxonGroups=9";
            restTemplate = new RestTemplate();
            response = restTemplate.getForObject(uri, Object[].class);
            array = new JSONArray(response);
            try {
                r = array.getJSONObject(0).getInt("ValidScientificNameId");
            } catch (JSONException e2) {
                return r;
            }
        }
        return r;
    }

    public boolean addPictureUrls(Species species, int scientificId) {
        String url = "https://artsobservasjoner.no/Media/Taxon/" + scientificId + "/SortOrder/SortBySighting/1/10#details";
        Document doc = null;
        try {
            doc = Jsoup.parse(new URL(url).openStream(),"UTF-8", url);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        Elements pics = doc.select("img.thumbnail ");
        Elements photographers = doc.select("span.photoby");        
        
        for(int i = 0; i < pics.size(); i++) {
            String src = pics.get(i).attr("abs:src");
            String fullPictureUrl = src.replace("thumbnail", "image");
            String photoBy = photographers.get(i).text().substring(6);
            
            Picture picture = new Picture();
            picture.setSpecies(species);
            picture.setUrl(fullPictureUrl);
            picture.setPhotographer(photoBy);
            pictureService.updatePicture(picture);

        }
        return true;
    }

    public boolean checkForDuplicate(String latinName) {
        List<Species> allSpecies = speciesService.findAll();
        for (Species s : allSpecies) {
            String fullName = s.getName();
            String scientificName = fullName.substring(fullName.indexOf("(")+1, fullName.indexOf(")"));
            if (latinName.equals(scientificName)) {
                return true;
            }
        }
        return false;
    }
}
