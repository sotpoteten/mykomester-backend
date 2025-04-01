package no.ntnu.isaksj.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(long id);

    List<Task> findAllByQuiz(Quiz quiz);    
}
