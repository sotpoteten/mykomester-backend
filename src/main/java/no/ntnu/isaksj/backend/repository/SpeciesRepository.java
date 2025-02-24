package no.ntnu.isaksj.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.ntnu.isaksj.backend.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    Species findById(long id);
}
