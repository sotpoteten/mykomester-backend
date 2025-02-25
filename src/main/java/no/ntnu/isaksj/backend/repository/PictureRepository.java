package no.ntnu.isaksj.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.ntnu.isaksj.backend.model.Picture;
import no.ntnu.isaksj.backend.model.Species;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findById(long id);
    
    List<Picture> findAllBySpecies(Species species);
}
