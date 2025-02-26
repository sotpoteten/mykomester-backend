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
    private String pictureUrl;

    @Column(nullable = false)
    private String photographer;

    @Column
    private String answeredSpecies;

    @Enumerated(EnumType.STRING)
    @Column
    private Normliststatus answeredCategory;

    @Column
    private String answeredNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonBackReference(value = "quiz-task")
    private Quiz quiz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_id")
    @JsonBackReference(value = "species-task")
    private Species species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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
}
