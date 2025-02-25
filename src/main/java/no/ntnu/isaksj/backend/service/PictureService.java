package no.ntnu.isaksj.backend.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Picture;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.repository.PictureRepository;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public Picture updatePicture(@NotNull Picture picture) {
        Picture updatedPicture = pictureRepository.save(picture);
        return updatedPicture;
    }

    public Picture findById(long id) {
        return pictureRepository.findById(id);
    }

    public List<Picture> findAllPicturesBySpecies(Species species) {
        return pictureRepository.findAllBySpecies(species);
    }
}
