package university.personnel;

import university.management.Course;
import java.time.LocalDate;

public class Student {
    private String name;
    private LocalDate enrollmentDate;

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
        return 3.5; //placeholder
    }

    public String registerForCourse(Course course) {
        return "Registered for course: " + course.getCourseName();
    }

    public String registerForCourse(String courseName) {
        return "Registered for course: " + courseName;
    }
}