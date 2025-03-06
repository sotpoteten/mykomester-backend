package no.ntnu.isaksj.backend.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.model.SpeciesStat;
import no.ntnu.isaksj.backend.model.Stat;
import no.ntnu.isaksj.backend.model.Task;
import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.service.QuizService;
import no.ntnu.isaksj.backend.service.SpeciesService;
import no.ntnu.isaksj.backend.service.UserService;

@RestController
public class StatsController {
    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private SpeciesService speciesService;

    @GetMapping("/stats/user/{email}")
    public ResponseEntity<Stat> getStatsByUser(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int nrOfQuizzes = 0;
        int totalScore = 0;
        int totalMaxScore = 0;

        List<Quiz> allQuizzesByUser = quizService.findAllQuizzesByUser(user);
        List<Task> allTasks = new ArrayList<>();

        for (Quiz q : allQuizzesByUser) {
            if (q.getTimeFinished() != null) {
                allTasks.addAll(q.getTasks());
                nrOfQuizzes++;
            } 
        }

        List<Species> allSpecies = speciesService.findAll();
        List<SpeciesStat> speciesStats = new ArrayList<>();
        allSpecies.forEach(s -> speciesStats.add(new SpeciesStat(s.getId(),s.getName())));

        for (Task t : allTasks) {
            SpeciesStat s = speciesStats.stream().filter(stat -> t.getSpecies().getId() == stat.getSpeciesId()).findFirst().orElse(null);
            int taskScore = 0;
            if (!t.isCorrectSpecies()) taskScore = 0;
            else if (t.isCorrectSpecies() && !t.isCorrectCategory()) taskScore = 1;
            else taskScore = 3;
            s.setMaxScore(s.getMaxScore() + 3);
            s.setScore(s.getScore() + taskScore);
            totalScore += taskScore;
            totalMaxScore += 3;
        }

        speciesStats.removeIf(s -> s.getMaxScore() == 0);
        speciesStats.forEach(s -> s.calculatePercentage());

        speciesStats.sort(null);

        Stat stat = new Stat(nrOfQuizzes, totalScore, totalMaxScore, totalScore/totalMaxScore);
        if (speciesStats.size() < 10) {
            List<SpeciesStat> subList = speciesStats.subList(0, speciesStats.size());
            stat.setWorstSpeciesOverall(subList);
            Collections.reverse(subList);
            stat.setBestSpeciesOverall(subList);
        } else {
            stat.setWorstSpeciesOverall(speciesStats.subList(0, 10));
            List<SpeciesStat> bestList = speciesStats.subList(speciesStats.size() - 10, speciesStats.size());
            Collections.reverse(bestList);
            stat.setBestSpeciesOverall(bestList);
        }
        
        return new ResponseEntity<Stat>(stat, HttpStatus.OK);
    }
}
