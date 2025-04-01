package no.ntnu.isaksj.backend.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import no.ntnu.isaksj.backend.enums.AnswerMode;
import no.ntnu.isaksj.backend.enums.QuizContent;
import no.ntnu.isaksj.backend.enums.QuizMode;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate timeFinished;

    @Column(nullable = false)
    private int nrOfTasks;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizContent quizContent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizMode quizMode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnswerMode answerMode;

    @Column
    private int points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-quiz")
    private User user;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "quiz-task")
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(LocalDate timeFinished) {
        this.timeFinished = timeFinished;
    }

    public int getNrOfTasks() {
        return nrOfTasks;
    }

    public void setNrOfTasks(int nrOfTasks) {
        this.nrOfTasks = nrOfTasks;
    }

    public QuizContent getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(QuizContent quizContent) {
        this.quizContent = quizContent;
    }

    public QuizMode getQuizMode() {
        return quizMode;
    }

    public void setQuizMode(QuizMode quizMode) {
        this.quizMode = quizMode;
    }

    public AnswerMode getAnswerMode() {
        return answerMode;
    }

    public void setAnswerMode(AnswerMode answerMode) {
        this.answerMode = answerMode;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
