package university.personnel;

import university.interfaces.Evaluatable;
import university.interfaces.Identifiable;
import university.interfaces.Trackable;
import university.management.Course;
import university.assessment.Assignment;
import university.assessment.Exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends UniversityMember implements Evaluatable, Trackable, Identifiable {
    private LocalDate enrollmentDate;
    private List<Assignment> assignments;
    private List<Exam> exams;
    private List<Course> registeredCourses;
    private String id;

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


    private List<Assignment> getAssignments() {
        if (assignments == null) {
            assignments = new ArrayList<>();
        }
        return assignments;
    }

    private List<Exam> getExams() {
        if (exams == null) {
            exams = new ArrayList<>();
        }
        return exams;
    }

    private List<Course> getRegisteredCourses() {
        if (registeredCourses == null) {
            registeredCourses = new ArrayList<>();
        }
        return registeredCourses;
    }

    public double calculateGPA() {
        if (registeredCourses.isEmpty()) return 0.0;

        double totalPoints = 0;
        int totalCredits = 0;

        for (Course course : registeredCourses) {
            double grade = course.getGrade();
            int credits = course.getCredits();

            totalPoints += grade * credits;
            totalCredits += credits;
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    public void addCourseGrade(Course course, double grade) {
        for (Course c : registeredCourses) {
            if (c.equals(course)) {
                c.setGrade(grade);
                return;
            }
        }
        course.setGrade(grade);
        registeredCourses.add(course);
    }

    public void addAssignment(Assignment assignment, double score) {
        assignment.setScore(score);
        getAssignments().add(assignment);
    }

    public void addExam(Exam exam, double score) {
        exam.setScore(score);
        getExams().add(exam);
    }

    public List<Assignment> getAssignmentsList() {
        return assignments;
    }

    public List<Exam> getExamsList() {
        return exams;
    }

    public String registerForCourse(Course course) {
        List<Course> courses = getRegisteredCourses();
        for (Course rc : courses) {
            if (rc.equals(course)) {
                return "Already registered for " + course.getCourseName();
            }
        }
        courses.add(course);
        return "Successfully registered for " + course.getCourseName();
    }

    public List<Course> getRegisteredCoursesList() {
        return getRegisteredCourses();
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating student performance...");
    }

    @Override
    public String getEvaluationCriteria() {
        return "Student Evaluation Criteria";
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking student progress...");
    }

    @Override
    public String getProgressReport() {
        return "Student Progress Report";
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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