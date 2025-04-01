package no.ntnu.isaksj.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.User;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findById(long id);

    List<Quiz> findAllByUser (User user);
}
