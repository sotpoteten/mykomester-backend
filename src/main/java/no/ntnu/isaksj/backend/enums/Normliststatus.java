package no.ntnu.isaksj.backend.enums;

public enum Normliststatus {
    SPISELIG,
    SPISELIG_MED_MERKNAD,
    IKKE_MATSOPP,
    GIFTIG,
    MEGET_GIFTIG;

    public static Normliststatus getStatusFromString(String status) {
        switch (status.toLowerCase()) {
            case "spiselig":
                return SPISELIG;
            case "spiselig med merknad":
                return SPISELIG_MED_MERKNAD;
            case "ikke matsopp":
                return IKKE_MATSOPP;
            case "giftig":
                return GIFTIG;
            case "meget giftig":
                return MEGET_GIFTIG;
            default:
                return null;
        }
    }
}
