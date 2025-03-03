package no.ntnu.isaksj.backend.enums;

public enum QuizMode {
    STANDARD,
    ARTSBESTEMMELSE,
    NORMLISTESTATUS;

    public static QuizMode getModeFromString(String mode) {
        switch (mode.toLowerCase()) {
            case "artsbestemmelse og normlistestatus":
                return STANDARD;
            case "kun artsbestemmelse":
                return ARTSBESTEMMELSE;
            case "kun normlistestatus":
                return NORMLISTESTATUS;
            default:
                return null;
        }
    }
}
