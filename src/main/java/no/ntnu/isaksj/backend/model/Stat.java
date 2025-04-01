package no.ntnu.isaksj.backend.model;

import java.util.List;

public class Stat {
    private int nrOfQuizzes;
    private int totalScore;
    private int totalMaxScore;
    private double averageScore;
    private List<SpeciesStat> bestSpeciesOverall;
    private List<SpeciesStat> worstSpeciesOverall;
    private List<SpeciesStat> bestSpeciesNames;
    private List<SpeciesStat> worstSpeciesNames;
    private List<SpeciesStat> bestSpeciesStatus;
    private List<SpeciesStat> worstSpeciesStatus;

    public Stat(int nrOfQuizzes, int totalScore, int totalMaxScore, double averageScore) {
        this.nrOfQuizzes = nrOfQuizzes;
        this.totalScore = totalScore;
        this.totalMaxScore = totalMaxScore;
        this.averageScore = averageScore;
    }
    
    public int getNrOfQuizzes() {
        return nrOfQuizzes;
    }
    public void setNrOfQuizzes(int nrOfQuizzes) {
        this.nrOfQuizzes = nrOfQuizzes;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public int getTotalMaxScore() {
        return totalMaxScore;
    }
    public void setTotalMaxScore(int totalMaxScore) {
        this.totalMaxScore = totalMaxScore;
    }
    public double getAverageScore() {
        return averageScore;
    }
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
    public List<SpeciesStat> getBestSpeciesOverall() {
        return bestSpeciesOverall;
    }
    public void setBestSpeciesOverall(List<SpeciesStat> bestSpeciesOverall) {
        this.bestSpeciesOverall = bestSpeciesOverall;
    }
    public List<SpeciesStat> getWorstSpeciesOverall() {
        return worstSpeciesOverall;
    }
    public void setWorstSpeciesOverall(List<SpeciesStat> worstSpeciesOverall) {
        this.worstSpeciesOverall = worstSpeciesOverall;
    }
    public List<SpeciesStat> getBestSpeciesNames() {
        return bestSpeciesNames;
    }
    public void setBestSpeciesNames(List<SpeciesStat> bestSpeciesNames) {
        this.bestSpeciesNames = bestSpeciesNames;
    }
    public List<SpeciesStat> getWorstSpeciesNames() {
        return worstSpeciesNames;
    }
    public void setWorstSpeciesNames(List<SpeciesStat> worstSpeciesNames) {
        this.worstSpeciesNames = worstSpeciesNames;
    }
    public List<SpeciesStat> getBestSpeciesStatus() {
        return bestSpeciesStatus;
    }
    public void setBestSpeciesStatus(List<SpeciesStat> bestSpeciesStatus) {
        this.bestSpeciesStatus = bestSpeciesStatus;
    }
    public List<SpeciesStat> getWorstSpeciesStatus() {
        return worstSpeciesStatus;
    }
    public void setWorstSpeciesStatus(List<SpeciesStat> worstSpeciesStatus) {
        this.worstSpeciesStatus = worstSpeciesStatus;
    }
}