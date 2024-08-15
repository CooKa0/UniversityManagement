package university.management;

import java.util.ArrayList;
import java.util.List;
import university.personnel.Professor;

public class Department {
    private String departmentName;
    private List<Course> courses;
    private List<Professor> professors;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return courses;
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

    public List<Professor> getProfessors() {
        if (professors == null) {
            professors = new ArrayList<>();
        }
        return professors;
    }

    public void addProfessor(Professor professor) {
        if (professors == null) {
            professors = new ArrayList<>();
        }
        professors.add(professor);
    }

    public String listCourses() {
        StringBuilder courseList = new StringBuilder();
        for (Course course : courses) {
            courseList.append(course.getCourseName()).append("\n");
        }
        return courseList.toString();
    }

    public String listCourses(boolean detailed) {
        StringBuilder courseList = new StringBuilder();
        for (Course course : courses) {
            if (detailed) {
                courseList.append("Course Name: ").append(course.getCourseName())
                        .append(", Credits: ").append(course.getCredits())
                        .append("\n");
            } else {
                courseList.append(course.getCourseName()).append("\n");
            }
        }
        return courseList.toString();
    }

    // Method to find a course by its name
    public Course findCourseByName(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }
}