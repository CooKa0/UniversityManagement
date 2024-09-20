package com.solvd.laba.university.enums;

public enum CourseLevel {
    UNDERGRADUATE("Undergraduate"),
    GRADUATE("Graduate"),
    POSTGRADUATE("Postgraduate"),
    CERTIFICATE("Certificate");

    private final String levelDescription;

    CourseLevel(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    static {
        System.out.println("Available Course Levels:");
        for (CourseLevel level : values()) {
            System.out.println(level.getLevelDescription());
        }
    }
}