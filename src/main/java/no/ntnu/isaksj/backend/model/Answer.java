package no.ntnu.isaksj.backend.model;

import no.ntnu.isaksj.backend.enums.Normliststatus;

public class Answer {
    private String answeredSpecies;
    private Normliststatus answeredCategory;
    private String answeredNote;
    private String correctSpecies;
    private Normliststatus correctCategory;
    private String correctNote;
    private boolean speciesCorrect;
    private boolean categoryCorrect;

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
    public String getCorrectSpecies() {
        return correctSpecies;
    }
    public void setCorrectSpecies(String correctSpecies) {
        this.correctSpecies = correctSpecies;
    }
    public Normliststatus getCorrectCategory() {
        return correctCategory;
    }
    public void setCorrectCategory(Normliststatus correctCategory) {
        this.correctCategory = correctCategory;
    }
    public String getCorrectNote() {
        return correctNote;
    }
    public void setCorrectNote(String correctNote) {
        this.correctNote = correctNote;
    }
    public boolean isSpeciesCorrect() {
        return speciesCorrect;
    }
    public void setSpeciesCorrect(boolean speciesCorrect) {
        this.speciesCorrect = speciesCorrect;
    }
    public boolean isCategoryCorrect() {
        return categoryCorrect;
    }
    public void setCategoryCorrect(boolean categoryCorrect) {
        this.categoryCorrect = categoryCorrect;
    }
}
