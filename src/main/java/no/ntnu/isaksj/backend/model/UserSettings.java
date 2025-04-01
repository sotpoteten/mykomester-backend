package no.ntnu.isaksj.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import no.ntnu.isaksj.backend.enums.AnswerMode;
import no.ntnu.isaksj.backend.enums.QuizContent;
import no.ntnu.isaksj.backend.enums.QuizMode;

@Entity
@Table(name = "user_settings")
public class UserSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-user_settings")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
