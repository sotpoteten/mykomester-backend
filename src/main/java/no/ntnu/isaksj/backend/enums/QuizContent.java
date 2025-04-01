package no.ntnu.isaksj.backend.enums;

public enum QuizContent {
    HELE_PENSUM,
    SPISELIGE,
    IKKE_MATSOPP,
    GIFTIGE;

    public static QuizContent getContentFromString(String content) {
        switch (content.toLowerCase()) {
            case "hele pensum":
                return HELE_PENSUM;
            case "spiselige":
                return SPISELIGE;
            case "ikke matsopp":
                return IKKE_MATSOPP;
            case "giftige":
                return GIFTIGE;
            default:
                return null;
        }
    }
}
