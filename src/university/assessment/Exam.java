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
        if (examDate == null) {
            examDate = LocalDate.now().plusDays(30);
            System.out.println("Exam scheduled for: " + examDate);
        } else {
            System.out.println("Exam is already scheduled for: " + examDate);
        }
    }

    public String getExamDetails(boolean includeDate) {
        if (includeDate) {
            return "Exam Name: " + examName + ", Date: " + examDate;
        } else {
            return "Exam Name: " + examName;
        }
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examName='" + examName + '\'' +
                ", examDate=" + examDate +
                '}';
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