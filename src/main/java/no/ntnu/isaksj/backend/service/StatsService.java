package no.ntnu.isaksj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.model.SpeciesStat;
import no.ntnu.isaksj.backend.model.Task;

@Service
public class StatsService {
    @Autowired
    private SpeciesService speciesService;

    public List<SpeciesStat> calculateSpeciesStatsByUser(List<Quiz> allQuizzesByUser) {
        List<Task> allTasks = new ArrayList<>();

        for (Quiz q : allQuizzesByUser) {
            if (q.getTimeFinished() != null) {
                allTasks.addAll(q.getTasks());
            } 
        }

        List<Species> allSpecies = speciesService.findAll();
        List<SpeciesStat> speciesStats = new ArrayList<>();
        allSpecies.forEach(s -> speciesStats.add(new SpeciesStat(s.getId(),s.getName())));

        for (Task t : allTasks) {
            SpeciesStat s = speciesStats.stream().filter(stat -> t.getSpecies().getId() == stat.getSpeciesId()).findFirst().orElse(null);
            int taskScore = 0;
            if (!t.isCorrectSpecies()) taskScore = 0;
            else if (t.isCorrectSpecies() && !t.isCorrectCategory()) taskScore = 2;
            else taskScore = 3;
            s.setMaxScore(s.getMaxScore() + 3);
            s.setScore(s.getScore() + taskScore);
        }

        speciesStats.removeIf(s -> s.getMaxScore() == 0);
        speciesStats.forEach(s -> s.calculatePercentage());

        speciesStats.sort(null);

        return speciesStats;
    }
}
