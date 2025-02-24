package no.ntnu.isaksj.backend.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.repository.QuizRepository;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepository quizRepository;

    public Quiz updateQuiz(@NotNull Quiz quiz) {
        Quiz updatedQuiz = quizRepository.save(quiz);
        return updatedQuiz;
    }

    public Quiz findById(long id) {
        return quizRepository.findById(id);
    }

    public List<Quiz> findAllQuizzesByUser(User user) {
        return quizRepository.findAllByUser(user);
    }
}
