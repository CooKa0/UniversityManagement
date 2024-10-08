package com.solvd.laba.university.management;

import com.solvd.laba.university.enums.CourseLevel;

public class Course {
    private String courseName;
    private int credits;
    private double grade;
    private CourseLevel level;

    public static final int MAX_COURSE_CREDITS = 5;

    public Course(String courseName, int credits, CourseLevel level) {
        this.courseName = courseName;
//        this.credits = credits;
        if (credits <= MAX_COURSE_CREDITS) {
            this.credits = credits;
        } else {
            throw new IllegalArgumentException("Course credits cannot exceed " + MAX_COURSE_CREDITS);
        }
        this.level = level;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public CourseLevel getLevel() {
        return level;
    }

    public String getCourseDetails() {
        return "Course Name: " + courseName + ", Credits: " + credits + ", Grade: " + grade + ", Level: " + level.getLevelDescription();
    }

    public String getCourseDetails(boolean detailed) {
        if (detailed) {
            return "Course Name: " + courseName + ", Credits: " + credits + ", Level: " + level.getLevelDescription();
        } else {
            return "Course Name: " + courseName;
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", grade=" + grade +
                ", level=" + level.getLevelDescription() +
                '}';
    }

    @Override
    public int hashCode() {
        return courseName.hashCode() + credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Course that = (Course) obj;
        return credits == that.credits && courseName.equals(that.courseName);
    }
}
