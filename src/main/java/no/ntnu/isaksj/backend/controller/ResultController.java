package no.ntnu.isaksj.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.Answer;
import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Result;
import no.ntnu.isaksj.backend.model.Task;
import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.service.QuizService;
import no.ntnu.isaksj.backend.service.UserService;

@RestController
public class ResultController {
    @Autowired
    private QuizService quizService;

    @Autowired
    private UserService userService;

    @GetMapping("/quizzes/result/latest/user/{email}")
    public ResponseEntity<Result> getResultsObject(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Quiz> allQuizzes = quizService.findAllQuizzesByUser(user);
        Quiz quiz = allQuizzes.get(allQuizzes.size() - 1);

        Result result = new Result();
        result.setScore(quiz.getPoints());
        result.setMaxScore(quiz.getNrOfTasks() * 3);
        List<Answer> answers = new ArrayList<>();
        for (Task t : quiz.getTasks()) {
            Answer answer = new Answer();
            answer.setAnsweredSpecies(t.getAnsweredSpecies());
            answer.setAnsweredCategory(t.getAnsweredCategory());
            answer.setAnsweredNote(t.getAnsweredNote());
            answer.setCorrectSpecies(t.getSpecies().getName());
            answer.setCorrectCategory(t.getSpecies().getCategory());
            answer.setAnsweredNote(t.getSpecies().getNote());
            answer.setSpeciesCorrect(t.isCorrectSpecies());
            answer.setCategoryCorrect(t.isCorrectCategory());
            
            answers.add(answer);
        }
        result.setAnswers(answers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("quizzes/result/tenlast/user/{email}")
    public ResponseEntity<List<Result>> getTenLastResults(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Quiz> allQuizzes = quizService.findAllQuizzesByUser(user);
        int cnt = 0;
        List<Result> tenLastResults = new ArrayList<>();

        while (allQuizzes.size() > cnt && cnt < 10) {
            Result result = new Result();
            result.setScore(allQuizzes.get(cnt).getPoints());
            result.setMaxScore(allQuizzes.get(cnt).getNrOfTasks() * 3);
            result.setDateFinished(allQuizzes.get(cnt).getTimeFinished());
            tenLastResults.add(result);
            cnt++;
        }
        return new ResponseEntity<>(tenLastResults, HttpStatus.OK);
    }
}
