package com.solvd.laba.university.management;

public final class UniversityConstants {
    public static final int MAX_STUDENTS_PER_CLASS = 30;
    public static final int MAX_PROFESSORS_PER_DEPARTMENT = 10;

    private UniversityConstants() {
    }

    public static void printConstants() {
        System.out.println("Max Students per Class: " + MAX_STUDENTS_PER_CLASS);
        System.out.println("Max Professors per Department: " + MAX_PROFESSORS_PER_DEPARTMENT);
    }
}