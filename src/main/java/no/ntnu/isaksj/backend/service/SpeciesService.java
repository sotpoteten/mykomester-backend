package no.ntnu.isaksj.backend.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.repository.SpeciesRepository;

@Service
public class SpeciesService {
    
    @Autowired
    private SpeciesRepository speciesRepository;

    public Species updateSpecies(@NotNull Species species) {
        Species updatedSpecies = speciesRepository.save(species);
        return updatedSpecies;
    }

    public Species findById(long id) {
        return speciesRepository.findById(id);
    }
}
