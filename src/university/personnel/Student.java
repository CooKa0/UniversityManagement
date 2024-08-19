package university.personnel;

import university.management.Course;
import university.assessment.Assignment;
import university.assessment.Exam;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends UniversityMember {
    private LocalDate enrollmentDate;
    private List<CourseGrade> courseGrades;
    private List<AssignmentScore> assignments;
    private List<ExamScore> exams;
    private List<RegisteredCourse> registeredCourses;

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

    private List<CourseGrade> getCourseGrades() {
        if (courseGrades == null) {
            courseGrades = new ArrayList<>();
        }
        return courseGrades;
    }

    private List<AssignmentScore> getAssignments() {
        if (assignments == null) {
            assignments = new ArrayList<>();
        }
        return assignments;
    }

    private List<ExamScore> getExams() {
        if (exams == null) {
            exams = new ArrayList<>();
        }
        return exams;
    }

    private List<RegisteredCourse> getRegisteredCourses() {
        if (registeredCourses == null) {
            registeredCourses = new ArrayList<>();
        }
        return registeredCourses;
    }

    public double calculateGPA() {
        List<CourseGrade> grades = getCourseGrades();
        if (grades.isEmpty()) return 0.0;
        double totalPoints = 0;
        for (CourseGrade courseGrade : grades) {
            totalPoints += courseGrade.getGrade();
        }
        return totalPoints / grades.size();
    }

    public void addCourseGrade(Course course, double grade) {
        List<CourseGrade> grades = getCourseGrades();
        for (CourseGrade cg : grades) {
            if (cg.getCourse().equals(course)) {
                cg.setGrade(grade);
                return;
            }
        }
        grades.add(new CourseGrade(course, grade));
    }

    public void addAssignment(Assignment assignment, double score) {
        getAssignments().add(new AssignmentScore(assignment, score));
    }

    public void addExam(Exam exam, double score) {
        getExams().add(new ExamScore(exam, score));
    }

    public List<AssignmentScore> getAssignmentsList() {
        return new ArrayList<>(getAssignments());
    }

    public List<ExamScore> getExamsList() {
        return new ArrayList<>(getExams());
    }

    public String registerForCourse(Course course) {
        List<RegisteredCourse> courses = getRegisteredCourses();
        for (RegisteredCourse rc : courses) {
            if (rc.getCourse().equals(course)) {
                return "Already registered for " + course.getCourseName();
            }
        }
        courses.add(new RegisteredCourse(course));
        return "Successfully registered for " + course.getCourseName();
    }

    public List<RegisteredCourse> getRegisteredCoursesList() {
        return new ArrayList<>(getRegisteredCourses());
    }

    public static class CourseGrade {
        private Course course;
        private double grade;

        public CourseGrade(Course course, double grade) {
            this.course = course;
            this.grade = grade;
        }

        public Course getCourse() {
            return course;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
    }

    public static class AssignmentScore {
        private Assignment assignment;
        private double score;

        public AssignmentScore(Assignment assignment, double score) {
            this.assignment = assignment;
            this.score = score;
        }

        public Assignment getAssignment() {
            return assignment;
        }

        public double getScore() {
            return score;
        }
    }

    public static class ExamScore {
        private Exam exam;
        private double score;

        public ExamScore(Exam exam, double score) {
            this.exam = exam;
            this.score = score;
        }

        public Exam getExam() {
            return exam;
        }

        public double getScore() {
            return score;
        }
    }

    public static class RegisteredCourse {
        private Course course;

        public RegisteredCourse(Course course) {
            this.course = course;
        }

        public Course getCourse() {
            return course;
        }
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