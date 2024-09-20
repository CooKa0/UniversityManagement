package com.solvd.laba.university.enums;

public enum ProfessorLevel {
    ASSISTANT("Assistant Professor", "Entry-level position for new faculty members."),
    ASSOCIATE("Associate Professor", "Mid-level position typically requiring tenure."),
    FULL("Full Professor", "Senior-level position with significant experience and accomplishments."),
    EMERITUS("Professor Emeritus", "Retired professor with special recognition.");

    private final String levelDescription;
    private final String responsibilities;

    ProfessorLevel(String levelDescription, String responsibilities) {
        this.levelDescription = levelDescription;
        this.responsibilities = responsibilities;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public String getDetails() {
        return levelDescription + ": " + responsibilities;
    }

    static {
        System.out.println("Available Professor Levels:");
        for (ProfessorLevel level : values()) {
            System.out.println(level.getDetails());
        }
    }
}
