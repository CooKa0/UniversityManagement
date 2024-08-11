package university.assessment;

import java.time.LocalDate;

public class Assignment {
    private String assignmentTitle;
    private LocalDate dueDate;

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

    public String getAssignmentDetails() {
        return "Assignment Title: " + assignmentTitle + ", Due Date: " + dueDate;
    }
}