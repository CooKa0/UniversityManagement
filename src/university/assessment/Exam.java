package university.assessment;



import university.interfaces.Evaluatable;
import university.interfaces.Identifiable;
import university.interfaces.Trackable;

import java.time.LocalDate;

public class Exam implements Evaluatable, Trackable, Identifiable {
    private String examName;
    private LocalDate examDate;
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
    public void evaluate() {
        System.out.println("Evaluating exam...");
    }

    @Override
    public String getEvaluationCriteria() {
        return "Exam Evaluation Criteria";
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking exam progress...");
    }

    @Override
    public String getProgressReport() {
        return progressReport;
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