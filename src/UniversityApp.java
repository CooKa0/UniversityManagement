import university.management.*;
import university.personnel.*;
import university.facilities.*;
import university.assessment.*;
import java.time.LocalDate;

public class UniversityApp {
    public static void main(String[] args) {
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

        System.out.println(university.getUniversityInfo());
        university.addDepartment(csDepartment);
        System.out.println(csDepartment.listCourses());

        // Use the methods
        System.out.println("Student Name: " + student.getName());
        student.setName("Alice Johnson");
        System.out.println("Updated Student Name: " + student.getName());

        System.out.println("Enrollment Date: " + student.getEnrollmentDate());
        student.setEnrollmentDate(LocalDate.of(2024, 10, 1));
        System.out.println("Updated Enrollment Date: " + student.getEnrollmentDate());

        System.out.println("GPA: " + student.calculateGPA());

        System.out.println(student.registerForCourse(javaCourse));
        System.out.println(professor.getProfessorDetails(true));
        System.out.println(library.getLibraryInfo());
        System.out.println(classroom.getClassroomInfo());
        exam.scheduleExam();
        System.out.println(assignment.getAssignmentDetails());
    }
}