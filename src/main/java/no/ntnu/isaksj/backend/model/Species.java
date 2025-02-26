package no.ntnu.isaksj.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import no.ntnu.isaksj.backend.enums.Normliststatus;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Normliststatus category;

    @Column
    private String note;

    @OneToOne(mappedBy = "species")
    @JsonManagedReference(value = "species-task")
    private Task task;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "species-picture")
    private List<Picture> pictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Normliststatus getCategory() {
        return category;
    }

    public void setCategory(Normliststatus category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
