package no.ntnu.isaksj.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.service.QuizService;
import no.ntnu.isaksj.backend.service.UserService;

@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;

    @Autowired
    private UserService userService;

    @GetMapping("/quizzes/user/{email}")
    public ResponseEntity<List<Quiz>> getAllQuizzesByUser(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Quiz> quizzes = quizService.findAllQuizzesByUser(user);
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/quizzes/user/latest/{email}")
    public ResponseEntity<Quiz> getLatestQuizByUser(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Quiz> quizzes = quizService.findAllQuizzesByUser(user);
        return new ResponseEntity<>(quizzes.get(quizzes.size() - 1), HttpStatus.OK);
    }

    @PostMapping("/quizzes/user/{email}")
    public ResponseEntity<Quiz> addQuiz(@PathVariable String email, @RequestBody Quiz quiz) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        quiz.setUser(user);
        
        Quiz addedQuiz = quizService.updateQuiz(quiz);
        quiz = quizService.createQuiz(addedQuiz);
        quiz = quizService.updateQuiz(quiz);
        return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
    } 

    @PutMapping("/quizzes/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        Quiz oldQuiz = quizService.findById(id);

        if (oldQuiz != null) {
            quiz.setId(oldQuiz.getId());

            quiz = quizService.updateQuiz(quiz);
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
