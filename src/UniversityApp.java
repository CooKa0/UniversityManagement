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

        // Output university information
        System.out.println(university.getUniversityInfo());
        university.addDepartment(csDepartment);
        System.out.println(csDepartment.listCourses());

        // Student details and actions
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + student.getName());
        student.setName("Alice Johnson");
        System.out.println("Updated Name: " + student.getName());
        System.out.println("Enrollment Date: " + student.getEnrollmentDate());
        student.setEnrollmentDate(LocalDate.of(2024, 10, 1));
        System.out.println("Updated Enrollment Date: " + student.getEnrollmentDate());
        System.out.println("GPA: " + student.calculateGPA());
        System.out.println(student.registerForCourse(javaCourse));

        // Professor details
        System.out.println("\nProfessor Details:");
        System.out.println(professor.getProfessorDetails(true));

        // Library information
        System.out.println("\nLibrary Information:");
        System.out.println(library.getLibraryInfo());

        // Classroom information
        System.out.println("\nClassroom Information:");
        System.out.println(classroom.getClassroomInfo());

        // Exam scheduling
        System.out.println("\nExam Details:");
        exam.scheduleExam();
        System.out.println(exam.getExamDetails(true));

        // Assignment details
        System.out.println("\nAssignment Details:");
        System.out.println(assignment.getAssignmentDetails());
    }
}