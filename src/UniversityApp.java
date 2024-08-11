import university.management.*;
import university.personnel.*;
import university.facilities.*;
import university.assessment.*;
import java.time.LocalDate;

public class UniversityApp {
    public static void main(String[] args) {
        // Create university and related entities
        University university = new University("Tech University", LocalDate.of(2000, 1, 1));
        Department csDepartment = new Department("Computer Science");
        Course javaCourse = new Course("Java Programming", 4);
        csDepartment.addCourse(javaCourse);

        Student student = new Student("Alice", LocalDate.of(2024, 9, 1));
        Professor professor = new Professor("Dr. Smith", LocalDate.of(2015, 5, 10));
        Library library = new Library("Main Library", 5000);
        Classroom classroom = new Classroom("A101", 30);
        Exam exam = new Exam("Final Exam", LocalDate.of(2024, 12, 15));
        Assignment assignment = new Assignment("Project 1", LocalDate.of(2024, 11, 15));

        // Assignment details
        System.out.println("\nAssignment Details:");
        System.out.println(assignment.getAssignmentDetails());

        // Using setter methods
        assignment.setAssignmentTitle("Updated Project 1");
        assignment.setDueDate(LocalDate.of(2024, 12, 1));
        System.out.println("Updated Assignment Details:");
        System.out.println(assignment.getAssignmentDetails());

        // Exam scheduling and details
        System.out.println("\nExam Details:");
        exam.scheduleExam();
        System.out.println(exam.getExamDetails(true));

        // Classroom information
        System.out.println("\nClassroom Information:");
        System.out.println(classroom.getClassroomInfo());

        // Library information
        System.out.println("\nLibrary Information:");
        System.out.println(library.getLibraryInfo());

        // University information
        System.out.println("\nUniversity Information:");
        System.out.println(university.getUniversityInfo());
        System.out.println("Total Universities: " + University.getUniversityCount());

        // Professor details
        System.out.println("\nProfessor Details:");
        System.out.println(professor.getProfessorDetails(true));

        // Student details and actions
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + student.getName());
    }
}