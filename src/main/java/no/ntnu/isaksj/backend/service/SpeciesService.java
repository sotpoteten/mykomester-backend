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

    public Picture getRandomPicture(Species species) {
        List<Picture> pictures = pictureService.findAllPicturesBySpecies(species);

        Random random = new Random();

        return pictures.get(random.nextInt(pictures.size()));
    }
}
