package com.solvd.laba.university.enums;

import java.util.Arrays;

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
        Arrays.stream(CourseLevel.values())
                .map(CourseLevel::getLevelDescription)
                .forEach(System.out::println);
    }
}