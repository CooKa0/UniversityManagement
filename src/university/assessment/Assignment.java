package university.assessment;

import java.time.LocalDate;

public class Assignment {
    private String assignmentTitle;
    private LocalDate dueDate;
    private double score;

    public Assignment(String assignmentTitle, LocalDate dueDate) {
        this.assignmentTitle = assignmentTitle;
        this.dueDate = dueDate;
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
}