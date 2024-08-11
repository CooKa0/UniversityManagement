package university.assessment;

import java.time.LocalDate;

public class Exam {
    private String examName;
    private LocalDate examDate;

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

    public void scheduleExam() {
        // Logic for scheduling exam
    }

    public String getExamDetails() {
        return "Exam Name: " + examName;
    }

    public String getExamDetails(boolean includeDate) {
        if (includeDate) {
            return "Exam Name: " + examName + ", Date: " + examDate;
        } else {
            return getExamDetails();
        }
    }
}