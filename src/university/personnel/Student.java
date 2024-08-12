package university.personnel;

import university.management.Course;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private LocalDate enrollmentDate;
    private Map<Course, Double> courseGrades = new HashMap<>();

    public Student(String name, LocalDate enrollmentDate) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double calculateGPA() {
        if (courseGrades.isEmpty()) return 0.0;
        double totalPoints = 0;
        for (double grade : courseGrades.values()) {
            totalPoints += grade;
        }
        return totalPoints / courseGrades.size();
    }
    public String getStudentDetails() {
        return "Student Name: " + name + ", Enrollment Date: " + enrollmentDate;
    }

    public String registerForCourse(Course course) {
        return "Registered for course: " + course.getCourseName();
    }

    public String registerForCourse(String courseName) {
        return "Registered for course: " + courseName;
    }

    public void addCourseGrade(Course course, double grade) {
        courseGrades.put(course, grade);
    }
}