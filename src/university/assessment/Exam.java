package university.assessment;

import university.interfaces.Evaluatable;
import university.interfaces.Identifiable;
import university.interfaces.Trackable;

import java.time.LocalDate;

public class Exam implements Evaluatable, Trackable, Identifiable {
    private String examName;
    private LocalDate examDate;
    private double score;
    private String id;
    private String progressReport;

    public Exam(String examName, LocalDate examDate) {
        this.examName = examName;
        this.examDate = examDate;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void scheduleExam() {
        if (examDate == null) {
            examDate = LocalDate.now().plusDays(30);
            System.out.println("Exam scheduled for: " + examDate);
        } else {
            System.out.println("Exam is already scheduled for: " + examDate);
        }
    }

    public String getExamDetails(boolean includeDate) {
        if (includeDate) {
            return "Exam Name: " + examName + ", Date: " + examDate + ", Score: " + score;
        } else {
            return "Exam Name: " + examName + ", Score: " + score;
        }
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examName='" + examName + '\'' +
                ", examDate=" + examDate +
                ", score=" + score +
                '}';
    }

    @Override
    public void evaluate() {
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }

    @Override
    public String getEvaluationCriteria() {
        return "Evaluation criteria:\n" +
                "90-100: A\n" +
                "80-89: B\n" +
                "70-79: C\n" +
                "60-69: D\n" +
                "Below 60: F";
    }

    @Override
    public void trackProgress() {
        if (examDate != null && LocalDate.now().isAfter(examDate)) {
            progressReport = "Exam has been conducted.";
        } else if (examDate != null && LocalDate.now().isBefore(examDate)) {
            long daysLeft = LocalDate.now().until(examDate).getDays();
            progressReport = "Exam scheduled in " + daysLeft + " days.";
        } else {
            progressReport = "Exam date is not set.";
        }
        System.out.println("Progress report: " + progressReport);
    }

    @Override
    public String getProgressReport() {
        return progressReport != null ? progressReport : "Progress report is not available.";
    }

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
    public int hashCode() {
        return examName.hashCode() + examDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Exam that = (Exam) obj;
        return examName.equals(that.examName) && examDate.equals(that.examDate);
    }
}