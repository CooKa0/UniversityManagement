package university.management;

import java.util.ArrayList;
import java.util.List;
import university.personnel.Professor;

public class Department {
    private String departmentName;
    private List<Course> courses = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();

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
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void addProfessor(Professor professor) {
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
}