package com.solvd.laba.university.personnel;

import com.solvd.laba.university.interfaces.Manageable;
import com.solvd.laba.university.management.Course;
import com.solvd.laba.university.utils.CustomLinkedList;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Professor extends UniversityMember implements Manageable {
    private CustomLinkedList<Course> managedCourses;

    public Professor(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    private CustomLinkedList<Course> getManagedCoursesList() {
        if (managedCourses == null) {
            managedCourses = new CustomLinkedList<>(); // Initialize when accessed
        }
        return managedCourses;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public String getDetails() {
        return "Professor: " + name + ", Hired on: " + hireDate;
    }

    public String getProfessorDetails(boolean includeHireDate) {
        if (includeHireDate) {
            return "Professor Name: " + name + ", Hire Date: " + hireDate;
        } else {
            return "Professor Name: " + name;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void manage() {
        System.out.println("Managing the following courses:");
        for (int i = 0; i < getManagedCoursesList().size(); i++) {
            Course course = getManagedCoursesList().get(i);
            System.out.println(course.getCourseDetails(true));
        }
    }

    @Override
    public String getManagementDetails() {
        StringBuilder details = new StringBuilder("Managed Courses:\n");
        for (int i = 0; i < getManagedCoursesList().size(); i++) {
            Course course = getManagedCoursesList().get(i);
            details.append(course.getCourseDetails(true)).append("\n");
        }
        return details.toString();
    }

    public void addManagedCourse(Course course) {
        getManagedCoursesList().add(course);
    }

    public void removeManagedCourse(int index) {
        getManagedCoursesList().remove(index);
    }

    public CustomLinkedList<Course> getManagedCourses() {
        return getManagedCoursesList();
    }
}