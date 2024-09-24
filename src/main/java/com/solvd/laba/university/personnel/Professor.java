package com.solvd.laba.university.personnel;

import com.solvd.laba.university.interfaces.Manageable;
import com.solvd.laba.university.management.Course;
import com.solvd.laba.university.enums.ProfessorLevel;

import java.time.LocalDate;
import java.util.List;

public class Professor extends UniversityMember implements Manageable {
    private ProfessorLevel level;

    public Professor(String name, LocalDate hireDate, ProfessorLevel level) {
        super(name, hireDate);
        this.level = level;
    }

    @Override
    public String getRole() {
        return "Professor (" + level.getLevelDescription() + ")";
    }

    @Override
    public String getDetails() {
        return "Professor: " + name + ", Level: " + level.getLevelDescription() + ", Hired on: " + hireDate;
    }

    @Override
    public String getManagementDetails() {
        return "Managed Courses:\n" + "Professor is assigned courses through department management.";
    }

    public String getProfessorDetails(boolean includeHireDate) {
        if (includeHireDate) {
            return "Professor Name: " + name + ", Hire Date: " + hireDate;
        } else {
            return "Professor Name: " + name;
        }
    }

    public void addCourse(Course course, List<Course> departmentCourses) {
        departmentCourses.add(course);
        System.out.println("Course " + course.getCourseName() + " added by " + name);
    }

    public void removeCourse(String courseName, List<Course> departmentCourses) {
        departmentCourses.removeIf(course -> course.getCourseName().equals(courseName));
        System.out.println("Course " + courseName + " removed by " + name);
    }

    public void listCourses(List<Course> departmentCourses) {
        System.out.println("Courses:");
        departmentCourses.forEach(course -> System.out.println(course.getCourseName()));
    }

    @Override
    public void manage() {
        System.out.println(getManagementDetails());
    }
}
