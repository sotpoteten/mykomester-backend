package no.ntnu.isaksj.backend.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Task;
import no.ntnu.isaksj.backend.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task updateTask(@NotNull Task task) {
        Task updatedTask = taskRepository.save(task);
        return updatedTask;
    }

    public Task findById(long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAllTasksByQuiz(Quiz quiz) {
        return taskRepository.findAllByQuiz(quiz);
    }
}
