package no.ntnu.isaksj.backend.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.service.SpeciesService;

@RestController
public class SpeciesController {
    
    @Autowired
    private SpeciesService speciesService;

    @GetMapping("/update_species_pictures")
    public ResponseEntity<Object> updateSpeciesPictures() {
        int id = getScientificId(speciesService.findById(1));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    public int getScientificId(Species species) {
        String uri = "https://artskart.artsdatabanken.no/publicapi/api/taxon?term=" + species.getName();
        RestTemplate restTemplate = new RestTemplate();
        Object[] response = restTemplate.getForObject(uri, Object[].class);
        JSONArray array = new JSONArray(response);
        int r = array.getJSONObject(0).getInt("ValidScientificNameId");
        return r;
    }
}
