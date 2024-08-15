package university.personnel;

import university.management.Course;
import university.assessment.Assignment;
import university.assessment.Exam;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student extends UniversityMember {
    private LocalDate enrollmentDate;
    private Map<Course, Double> courseGrades;
    private Map<Assignment, Double> assignments;
    private Map<Exam, Double> exams;
    private Map<Course, String> registeredCourses;

    public Student(String name, LocalDate enrollmentDate) {
        super(name);
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String getDetails() {
        return "Student Name: " + name + ", Enrollment Date: " + enrollmentDate;
    }

    private Map<Course, Double> getCourseGrades() {
        if (courseGrades == null) {
            courseGrades = new HashMap<>();
        }
        return courseGrades;
    }

    private Map<Assignment, Double> getAssignmentsMap() {
        if (assignments == null) {
            assignments = new HashMap<>();
        }
        return assignments;
    }

    private Map<Exam, Double> getExamsMap() {
        if (exams == null) {
            exams = new HashMap<>();
        }
        return exams;
    }

    private Map<Course, String> getRegisteredCoursesMap() {
        if (registeredCourses == null) {
            registeredCourses = new HashMap<>();
        }
        return registeredCourses;
    }

    public double calculateGPA() {
        Map<Course, Double> grades = getCourseGrades();
        if (grades.isEmpty()) return 0.0;
        double totalPoints = 0;
        for (double grade : grades.values()) {
            totalPoints += grade;
        }
        return totalPoints / grades.size();
    }

    public void addCourseGrade(Course course, double grade) {
        getCourseGrades().put(course, grade);
    }

    public void addAssignment(Assignment assignment, double score) {
        getAssignmentsMap().put(assignment, score);
    }

    public void addExam(Exam exam, double score) {
        getExamsMap().put(exam, score);
    }

    public Map<Assignment, Double> getAssignments() {
        return getAssignmentsMap();
    }

    public Map<Exam, Double> getExams() {
        return getExamsMap();
    }

    public String registerForCourse(Course course) {
        Map<Course, String> courses = getRegisteredCoursesMap();

        if (courses.containsKey(course)) {
            return "Already registered for " + course.getCourseName();
        } else {
            courses.put(course, "Registered");
            return "Successfully registered for " + course.getCourseName();
        }
    }

    public Map<Course, String> getRegisteredCourses() {
        return getRegisteredCoursesMap();
    }

    @Override
    public String toString() {
        return super.toString() + ", GPA: " + calculateGPA();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) (calculateGPA() * 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Student student = (Student) obj;

        return calculateGPA() == student.calculateGPA();
    }
}