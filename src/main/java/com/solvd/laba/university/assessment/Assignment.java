package com.solvd.laba.university.assessment;

import java.time.LocalDate;
import com.solvd.laba.university.interfaces.Evaluatable;
import com.solvd.laba.university.interfaces.Identifiable;
import com.solvd.laba.university.interfaces.Trackable;

public class Assignment implements Evaluatable, Trackable, Identifiable {
    private String assignmentTitle;
    private LocalDate dueDate;
    private double score;
    private String id;
    private String progressReport;

    public Assignment(String assignmentTitle, LocalDate dueDate) {
        this.assignmentTitle = assignmentTitle;
        this.dueDate = dueDate;
        this.progressReport = "Not started";
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAssignmentDetails() {
        return "Assignment Title: " + assignmentTitle + ", Due Date: " + dueDate + ", Score: " + score;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentTitle='" + assignmentTitle + '\'' +
                ", dueDate=" + dueDate +
                ", score=" + score +
                '}';
    }

    @Override
    public int hashCode() {
        return assignmentTitle.hashCode() + dueDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Assignment that = (Assignment) obj;
        return assignmentTitle.equals(that.assignmentTitle) && dueDate.equals(that.dueDate);
    }

    @Override
    public void evaluate() {
        if (score >= 85) {
            System.out.println("Grade: Excellent");
        } else if (score >= 70) {
            System.out.println("Grade: Good");
        } else if (score >= 50) {
            System.out.println("Grade: Satisfactory");
        } else {
            System.out.println("Grade: Needs Improvement");
        }
    }

    @Override
    public String getEvaluationCriteria() {
        return "Evaluation criteria:\n" +
                "85-100: Excellent\n" +
                "70-84: Good\n" +
                "50-69: Satisfactory\n" +
                "Below 50: Needs Improvement";
    }

    @Override
    public String getProgressReport() {
        return progressReport;
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
    public void trackProgress() {
        LocalDate currentDate = LocalDate.now();
        if (dueDate != null) {
            long daysLeft = java.time.temporal.ChronoUnit.DAYS.between(currentDate, dueDate);
            if (daysLeft > 30) {
                progressReport = "Assignment is on track. Due date is " + daysLeft + " days away.";
            } else if (daysLeft > 0) {
                progressReport = "Assignment is approaching due date. Only " + daysLeft + " days left.";
            } else {
                progressReport = "Assignment is overdue by " + Math.abs(daysLeft) + " days.";
            }
        } else {
            progressReport = "Due date not set.";
        }
        System.out.println(progressReport);
    }
}