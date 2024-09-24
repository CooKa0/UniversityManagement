package com.solvd.laba.university.personnel;

import com.solvd.laba.university.interfaces.Manageable;
import com.solvd.laba.university.management.Course;
import com.solvd.laba.university.management.Department;
import com.solvd.laba.university.enums.ProfessorLevel;


import java.time.LocalDate;
import java.util.stream.Collectors;


public class Professor extends UniversityMember implements Manageable {
    private Department department;
    private ProfessorLevel level;

    public Professor(String name, LocalDate hireDate, Department department, ProfessorLevel level) {
        super(name, hireDate);
        this.department = department;
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
        return department.getCourses().values().stream()
                .map(course -> course.getCourseDetails(true))
                .collect(Collectors.joining("\n", "Managed Courses:\n", ""));
    }

    public String getProfessorDetails(boolean includeHireDate) {
        if (includeHireDate) {
            return "Professor Name: " + name + ", Hire Date: " + hireDate;
        } else {
            return "Professor Name: " + name;
        }
    }


    public void addCourse(Course course) {
        department.addCourse(course);
        System.out.println("Course " + course.getCourseName() + " added by " + name);
    }

    public void removeCourse(String courseName) {
        department.getCourses().remove(courseName);
        System.out.println("Course " + courseName + " removed by " + name);
    }

    public void listCourses() {
        System.out.println("Courses in " + department.getDepartmentName() + ":");
        System.out.println(department.listCourses());
    }

    @Override
    public void manage() {
        System.out.println(getManagementDetails());
    }
}
