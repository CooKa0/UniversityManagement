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
        Classroom classroom = new Classroom("A101", 30);
        Exam exam = new Exam("Final Exam", LocalDate.of(2024, 12, 15));
        Assignment assignment = new Assignment("Project 1", LocalDate.of(2024, 11, 15));
        Library library1 = new Library("Main Library", 5000);
        Library library2 = new Library("Science Library", 3000);

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

        // Display library information
        System.out.println(library1.getLibraryInfo());
        System.out.println(library2.getLibraryInfo());

        // Access and modify library details
        String lib1Name = library1.getLibraryName();
        int lib1Books = library1.getBookCount();

        // Print the details
        System.out.println("\nLibrary 1 Name: " + lib1Name);
        System.out.println("Library 1 Book Count: " + lib1Books);

        // Update library information
        library1.setLibraryName("Updated Main Library");
        library1.setBookCount(6000);

        // Print updated library details
        System.out.println("\nUpdated Library 1 Information:");
        System.out.println(library1.getLibraryInfo());

        // Display total number of books across all libraries
        System.out.println("Total Books in All Libraries: " + Library.getTotalBooks());

        // Further updates to demonstrate all methods
        library2.setBookCount(8500);
        System.out.println("\nUpdated Library 2 Information:");
        System.out.println(library2.getLibraryInfo());
        System.out.println("Total Books in All Libraries: " + Library.getTotalBooks());

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