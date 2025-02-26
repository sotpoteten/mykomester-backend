package no.ntnu.isaksj.backend.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.enums.QuizContent;
import no.ntnu.isaksj.backend.model.Quiz;
import no.ntnu.isaksj.backend.model.Species;
import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.repository.QuizRepository;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private SpeciesService speciesService;

    @Autowired 
    private TaskService taskService;

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

    public Quiz createQuiz(Quiz quiz) {
        int nrOfTasks = quiz.getNrOfTasks();
        List<Species> speciesList;

        if (quiz.getQuizContent() == QuizContent.HELE_PENSUM) {
            speciesList = speciesService.findAll();
        } else {
            speciesList = speciesService.findAll();
        }

        for (int i = 0; i < nrOfTasks; i++) {
            taskService.createTask(speciesList, quiz);
        }

        return quiz;
    }
}
