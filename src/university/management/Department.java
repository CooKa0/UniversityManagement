package university.management;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Course> courses = new ArrayList<>();

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

    public String listCourses() {
        return "Courses: " + courses;
    }

    public String listCourses(boolean detailed) {
        if (detailed) {
            StringBuilder details = new StringBuilder("Detailed Course List:\n");
            for (Course course : courses) {
                details.append(course.getCourseName()).append(", Credits: ").append(course.getCredits()).append("\n");
            }
            return details.toString();
        } else {
            return listCourses();
        }
    }
}