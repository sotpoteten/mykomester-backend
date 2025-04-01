package no.ntnu.isaksj.backend.enums;

public enum AnswerMode {
    SEARCH,
    MULTIPLE_CHOICE,
    TEXT;

    public static AnswerMode getModeFromString(String mode) {
        switch (mode.toLowerCase()) {
            case "søk og valg":
                return SEARCH;
            case "flervalg (4 alternativer)":
                return MULTIPLE_CHOICE;
            case "fritekst":
                return TEXT;
            default:
                return null;
        }
    }
}
