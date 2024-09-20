package com.solvd.laba.university.personnel;

import com.solvd.laba.university.interfaces.Manageable;
import com.solvd.laba.university.management.Course;
import com.solvd.laba.university.management.Department;
import com.solvd.laba.university.enums.ProfessorLevel;
import com.solvd.laba.university.utils.UniversityUtils;

import java.time.LocalDate;
import java.util.Arrays;

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
        StringBuilder details = new StringBuilder("Managed Courses:\n");
        for (Course course : department.getCourses().values()) {
            details.append(course.getCourseDetails(true)).append("\n");
        }
        return details.toString();
    }

    public String getProfessorDetails(boolean includeHireDate) {
        if (includeHireDate) {
            return "Professor Name: " + name + ", Hire Date: " + hireDate;
        } else {
            return "Professor Name: " + name;
        }
    }

    public static void printProfessorLevels() {
        System.out.println("\nAvailable Professor Levels:");
        Arrays.stream(ProfessorLevel.values()).forEach(UniversityUtils.printProfessorLevelDetails);
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
