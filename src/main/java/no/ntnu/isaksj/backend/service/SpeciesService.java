package no.ntnu.isaksj.backend.service;

import java.util.List;
import java.util.Random;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Picture;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.repository.SpeciesRepository;

@Service
public class SpeciesService {
    
    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private PictureService pictureService;

    public Species updateSpecies(@NotNull Species species) {
        Species updatedSpecies = speciesRepository.save(species);
        return updatedSpecies;
    }

    public Species findById(long id) {
        return speciesRepository.findById(id);
    }

    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    public void deleteSpecies(Species species) {
        speciesRepository.delete(species);
    }

    public Picture getRandomPicture(Species species) {
        List<Picture> pictures = pictureService.findAllPicturesBySpecies(species);

        Random random = new Random();

        return pictures.get(random.nextInt(pictures.size()));
    }

    public Picture getRandomUniquePicture(Species species, Picture[] usedPictures) {
        List<Picture> pictures = pictureService.findAllPicturesBySpecies(species);
        Random random = new Random();
        int randInt = random.nextInt(pictures.size());

        while (pictures.get(randInt).equals(usedPictures[0]) || pictures.get(randInt).equals(usedPictures[1])) {
            randInt = random.nextInt(pictures.size());
        }
        
        return pictures.get(randInt);
    }
}
