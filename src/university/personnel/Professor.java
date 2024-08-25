package university.personnel;

import university.interfaces.Manageable;
import university.management.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Professor extends UniversityMember implements Manageable {
    private List<Course> managedCourses;

    public Professor(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    private void initializeManagedCourses() {
        if (managedCourses == null) {
            managedCourses = new ArrayList<>();
        }
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
        initializeManagedCourses();
        System.out.println("Managing the following courses:");
        for (Course course : managedCourses) {
            System.out.println(course.getCourseDetails(true));
        }
    }

    @Override
    public String getManagementDetails() {
        initializeManagedCourses();
        StringBuilder details = new StringBuilder("Managed Courses:\n");
        for (Course course : managedCourses) {
            details.append(course.getCourseDetails(true)).append("\n");
        }
        return details.toString();
    }

    public void setManagedCourses(List<Course> courses) {
        this.managedCourses = courses;
    }

    public List<Course> getManagedCourses() {
        initializeManagedCourses();
        return managedCourses;
    }
}