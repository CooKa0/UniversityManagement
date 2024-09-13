package com.solvd.laba.university.management;

public interface UniversityConstants {
    int MAX_STUDENTS_PER_CLASS = 30;
    int MAX_PROFESSORS_PER_DEPARTMENT = 10;

    static void printConstants() {
        System.out.println("Max Students per Class: " + MAX_STUDENTS_PER_CLASS);
        System.out.println("Max Professors per Department: " + MAX_PROFESSORS_PER_DEPARTMENT);
    }
}