package no.ntnu.isaksj.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import no.ntnu.isaksj.backend.enums.Normliststatus;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String pictureUrl;

    @Column
    private String answeredSpecies;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Normliststatus answeredCategory;

    @Column
    private String answeredNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonBackReference(value = "quiz-task")
    private Quiz quiz;



}
