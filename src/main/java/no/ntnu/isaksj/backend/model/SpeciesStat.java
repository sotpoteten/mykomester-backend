package no.ntnu.isaksj.backend.model;

public class SpeciesStat implements Comparable<SpeciesStat> {
    private Long speciesId;
    private String speciesName;
    private double percentage;
    private int score;
    private int maxScore;

    public SpeciesStat(Long speciesId, String speciesName) {
        this.speciesId = speciesId;
        this.speciesName = speciesName;
    }
    public String getSpeciesName() {
        return speciesName;
    }
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
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
    public Long getSpeciesId() {
        return speciesId;
    }
    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }
    public void calculatePercentage() {
        this.percentage = score / maxScore * 100;
    }
    @Override
    public int compareTo(SpeciesStat o) {
        return (int) (this.percentage - o.getPercentage());
    }
}
