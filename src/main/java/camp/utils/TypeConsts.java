package camp.utils;

public enum TypeConsts {
    SUBJECT_TYPE_MANDATORY("MANDATORY"),
    SUBJECT_TYPE_CHOICE("CHOICE"),
    INDEX_TYPE_STUDENT("ST"),
    INDEX_TYPE_SUBJECT("SU"),
    INDEX_TYPE_SCORE("SC");

    private String selectedType;

    private TypeConsts(String selectedType) {
        this.selectedType = selectedType;
    }

    public String getType() {
        return selectedType;
    }
}
