package no.ntnu.isaksj.backend.service;

import java.util.List;
import java.util.Random;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Picture;
import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.model.Task;
import no.ntnu.isaksj.backend.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SpeciesService speciesService;

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

    public Task createTask(List<Species> speciesList, Quiz quiz) {
        Task newTask = new Task();
        newTask.setQuiz(quiz);
        newTask.setCorrectCategory(false);
        newTask.setCorrectSpecies(false);
        Random random = new Random();
        Species species = speciesList.get(random.nextInt(speciesList.size()));
        newTask.setSpecies(species);
        Picture picture = speciesService.getRandomPicture(species);
        newTask.setPictureUrl(picture.getUrl());
        newTask.setPhotographer(picture.getPhotographer());
        taskRepository.save(newTask);
        return newTask;
    }
}
