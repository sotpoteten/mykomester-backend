package no.ntnu.isaksj.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import no.ntnu.isaksj.backend.enums.Normliststatus;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String speciesName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String pictureUrls;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String photographers;

    @Column
    private String answeredSpecies;

    @Enumerated(EnumType.STRING)
    @Column
    private Normliststatus answeredCategory;

    @Column
    private String answeredNote;

    @Column
    private boolean correctSpecies;

    @Column
    private boolean correctCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonBackReference(value = "quiz-task")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    @JsonBackReference(value = "species-task")
    private Species species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(String pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public String getAnsweredSpecies() {
        return answeredSpecies;
    }

    public void setAnsweredSpecies(String answeredSpecies) {
        this.answeredSpecies = answeredSpecies;
    }

    public Normliststatus getAnsweredCategory() {
        return answeredCategory;
    }

    public void setAnsweredCategory(Normliststatus answeredCategory) {
        this.answeredCategory = answeredCategory;
    }

    public String getAnsweredNote() {
        return answeredNote;
    }

    public void setAnsweredNote(String answeredNote) {
        this.answeredNote = answeredNote;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getPhotographers() {
        return photographers;
    }

    public void setPhotographers(String photographers) {
        this.photographers = photographers;
    }

    public boolean isCorrectSpecies() {
        return correctSpecies;
    }

    public void setCorrectSpecies(boolean correctSpecies) {
        this.correctSpecies = correctSpecies;
    }

    public boolean isCorrectCategory() {
        return correctCategory;
    }

    public void setCorrectCategory(boolean correctCategory) {
        this.correctCategory = correctCategory;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
}
