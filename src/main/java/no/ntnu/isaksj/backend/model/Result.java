package no.ntnu.isaksj.backend.model;

import java.time.LocalDate;
import java.util.List;

public class Result {
    private int score;
    private int maxScore;
    private LocalDate dateFinished;
    private List<Answer> answers;

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public LocalDate getDateFinished() {
        return dateFinished;
    }
    public void setDateFinished(LocalDate dateFinished) {
        this.dateFinished = dateFinished;
    } 
}
