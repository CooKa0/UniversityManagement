package com.solvd.laba.university.personnel;

import com.solvd.laba.university.enums.Currency;
import com.solvd.laba.university.interfaces.Evaluatable;
import com.solvd.laba.university.interfaces.Identifiable;
import com.solvd.laba.university.interfaces.Trackable;
import com.solvd.laba.university.management.Course;
import com.solvd.laba.university.assessment.Assignment;
import com.solvd.laba.university.assessment.Exam;
import com.solvd.laba.university.utils.CurrencyUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends UniversityMember implements Evaluatable, Trackable, Identifiable {
    private LocalDate enrollmentDate;
    private List<Assignment> assignments;
    private List<Exam> exams;
    private List<Course> registeredCourses;
    private String id;
    private String progressReport;
    private double scholarshipAmount;

    public Student(String name, LocalDate enrollmentDate) {
        super(name);
        this.enrollmentDate = enrollmentDate;
        this.progressReport = "Initial progress report";
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
        return registeredCourses.stream()
                .mapToDouble(course -> course.getGrade() * course.getCredits())
                .average().orElse(0.0);
    }

    public void addCourseGrade(Course course, double grade) {
        registeredCourses.stream()
                .filter(c -> c.equals(course))
                .findFirst()
                .ifPresentOrElse(c -> c.setGrade(grade), () -> {
                    course.setGrade(grade);
                    registeredCourses.add(course);
                });
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
        if (getRegisteredCourses().stream().anyMatch(rc -> rc.equals(course))) {
            return "Already registered for " + course.getCourseName();
        }
        getRegisteredCourses().add(course);
        return "Successfully registered for " + course.getCourseName();
    }

    public List<Course> getRegisteredCoursesList() {
        return getRegisteredCourses();
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double amount) {
        this.scholarshipAmount = amount;
    }

    public String convertAndFormatScholarship(Currency targetCurrency) {
        // Log the conversion
        Currency fromCurrency = Currency.PLN;
        CurrencyUtil.logCurrencyConversion(scholarshipAmount, fromCurrency, targetCurrency);

        // Convert and format the scholarship amount
        double convertedAmount = CurrencyUtil.convertToCurrency.apply(scholarshipAmount, targetCurrency);
        String formattedAmount = CurrencyUtil.customFormatter().apply(convertedAmount);

        return formattedAmount + " " + targetCurrency;
    }


    @Override
    public void evaluate() {
        System.out.println("\nEvaluating student performance...");
        double averageAssignmentScore = getAssignments().stream().mapToDouble(Assignment::getScore).average().orElse(0);
        double averageExamScore = getExams().stream().mapToDouble(Exam::getScore).average().orElse(0);
        double overallPerformance = (averageAssignmentScore + averageExamScore) / 2;

        System.out.println("Average Assignment Score: " + averageAssignmentScore);
        System.out.println("Average Exam Score: " + averageExamScore);
        System.out.println("Overall Performance Score: " + overallPerformance);
    }

    @Override
    public String getEvaluationCriteria() {
        return "Student Evaluation Criteria:\n" +
                "Assignments and Exams are evaluated based on average scores.\n" +
                "Overall performance is the average of assignment and exam scores.";
    }

    @Override
    public void trackProgress() {
        LocalDate currentDate = LocalDate.now();
        StringBuilder report = new StringBuilder();
        report.append("Student Progress Report:\n");
        report.append("Date: ").append(currentDate).append("\n");

        if (getRegisteredCourses().isEmpty()) {
            report.append("No courses registered.\n");
        } else {
            report.append("Registered Courses:\n");
            for (Course course : getRegisteredCourses()) {
                report.append(course.getCourseDetails()).append("\n");
            }
        }

        if (getAssignments().isEmpty() && getExams().isEmpty()) {
            report.append("No assignments or exams available.\n");
        } else {
            report.append("Assignments:\n");
            for (Assignment assignment : getAssignments()) {
                report.append(assignment.getAssignmentDetails()).append("\n");
            }
            report.append("Exams:\n");
            for (Exam exam : getExams()) {
                report.append(exam.getExamDetails(true)).append("\n");
            }
        }

        this.progressReport = report.toString();
    }

    @Override
    public String getProgressReport() {
        return this.progressReport;
    }

    @Override
    public void setProgressReport(String progressReport) {
        this.progressReport = progressReport;
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

        if (obj instanceof Student) {
            Student student = (Student) obj;
            return calculateGPA() == student.calculateGPA();
        }
        return false;
    }


}