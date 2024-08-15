import university.management.*;
import university.personnel.*;
import university.facilities.*;
import university.assessment.*;
import university.utils.UniversityUtils;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class UniversityApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create university
        University university = new University("Tech University", LocalDate.of(2010, 1, 1));

        // Create department
        Department csDepartment = new Department("Computer Science");

        // Create courses
        Course javaCourse = new Course("Java Programming", 4);
        Course dataStructuresCourse = new Course("Data Structures", 3);
        csDepartment.addCourse(javaCourse);
        csDepartment.addCourse(dataStructuresCourse);

        // Update the department name and add the department to the university
        csDepartment.setDepartmentName("Department of Computer Science");
        university.addDepartment(csDepartment);

        // Create a new student and register for courses
        Student student = new Student("Alice", LocalDate.of(2024, 9, 1));
        university.addStudent(student);

        System.out.println("Student Details:");
        UniversityUtils.printMemberDetails(student);

        String registrationMessage1 = student.registerForCourse(javaCourse);
        String registrationMessage2 = student.registerForCourse(dataStructuresCourse);

        System.out.println("\nCourse Registration:");
        System.out.println(registrationMessage1);
        System.out.println(registrationMessage2);

        // Add grades and calculate GPA
        student.addCourseGrade(javaCourse, 3.7);
        student.addCourseGrade(dataStructuresCourse, 3.9);
        System.out.println("\nStudent GPA:");
        System.out.println("GPA: " + student.calculateGPA());

        // Create professor, classroom, exam, assignment, and libraries
        Professor professor = new Professor("Dr. Smith", LocalDate.of(2020, 5, 10));
        csDepartment.addProfessor(professor);

        Classroom classroom = new Classroom("A101", 30);
        Library library1 = new Library("Main Library", 5000);
        Library library2 = new Library("Science Library", 3000);

        university.addClassroom(classroom);
        university.addLibrary(library1);
        university.addLibrary(library2);

        Exam exam = new Exam("Final Exam", LocalDate.of(2024, 12, 15));
        Assignment assignment = new Assignment("Project 1", LocalDate.of(2024, 11, 15));

        // Assignments and Exams
        student.addAssignment(assignment, 85.0);
        student.addExam(exam, 90.0);

        // Print assignment and exam details
        System.out.println("\nAssignments:");
        for (Map.Entry<Assignment, Double> entry : student.getAssignments().entrySet()) {
            Assignment a = entry.getKey();
            Double score = entry.getValue();
            System.out.println(a.getAssignmentDetails() + " - Score: " + score);
        }

        System.out.println("\nExams:");
        for (Map.Entry<Exam, Double> entry : student.getExams().entrySet()) {
            Exam e = entry.getKey();
            Double score = entry.getValue();
            System.out.println(e.getExamDetails(true) + " - Score: " + score);
        }

        // Display and update assignment details
        System.out.println("\nAssignment Details:");
        System.out.println(assignment.getAssignmentDetails());
        System.out.println("Assignment Title: " + assignment.getAssignmentTitle());
        System.out.println("Due Date: " + assignment.getDueDate());

        assignment.setAssignmentTitle("Updated Project 1");
        assignment.setDueDate(LocalDate.of(2024, 12, 1));

        System.out.println("Updated Assignment Details:");
        System.out.println(assignment.getAssignmentDetails());

        // Display and update exam details
        System.out.println("\nExam Details:");
        System.out.println("Exam Name: " + exam.getExamName());
        System.out.println("Exam Date: " + exam.getExamDate());

        exam.setExamName("Midterm Exam");
        exam.setExamDate(LocalDate.of(2024, 11, 15));

        System.out.println("Updated Exam Details:");
        System.out.println("Exam Name: " + exam.getExamName());
        System.out.println("Exam Date: " + exam.getExamDate());

        exam.scheduleExam();
        System.out.println(exam.getExamDetails(true));

        // Display and update classroom information
        System.out.println("\nClassroom Information:");
        System.out.println(classroom.getClassroomInfo());
        System.out.println("Room Number: " + classroom.getRoomNumber());
        System.out.println("Capacity: " + classroom.getCapacity());

        classroom.setRoomNumber("B202");
        classroom.setCapacity(40);

        System.out.println("\nUpdated Classroom Information:");
        System.out.println(classroom.getClassroomInfo());
        System.out.println("Updated Room Number: " + classroom.getRoomNumber());
        System.out.println("Updated Capacity: " + classroom.getCapacity());

        System.out.println("\nClassrooms:");
        for (Classroom cls : university.getClassrooms()) {
            System.out.println(cls.getClassroomInfo());
        }

        // Display and update library information
        System.out.println("\nLibrary Information:");
        System.out.println(library1.getLibraryInfo());
        System.out.println(library2.getLibraryInfo());

        String lib1Name = library1.getLibraryName();
        int lib1Books = library1.getBookCount();

        System.out.println("\nLibrary 1 Name: " + lib1Name);
        System.out.println("Library 1 Book Count: " + lib1Books);

        library1.setLibraryName("Updated Main Library");
        library1.setBookCount(6000);

        System.out.println("\nUpdated Library 1 Information:");
        System.out.println(library1.getLibraryInfo());
        System.out.println("Total Books in All Libraries: " + Library.getTotalBooks());

        library2.setBookCount(8500);

        System.out.println("\nUpdated Library 2 Information:");
        System.out.println(library2.getLibraryInfo());
        System.out.println("Total Books in All Libraries: " + Library.getTotalBooks());

        System.out.println("\nLibraries:");
        for (Library lib : university.getLibraries()) {
            System.out.println(lib.getLibraryInfo());
        }

        // Display department information
        System.out.println("\nDepartment Information:");
        System.out.println("Department Name: " + csDepartment.getDepartmentName());

        System.out.println("Courses with Credits:");
        for (Course course : csDepartment.getCourses()) {
            System.out.println(course.getCourseName() + " - Credits: " + course.getCredits());
        }

        System.out.println("\nCourses (Basic):");
        System.out.println(csDepartment.listCourses());

        System.out.println("\nCourses (Detailed):");
        System.out.println(csDepartment.listCourses(true));

        // Display and update university information
        System.out.println("\nUniversity Information:");
        System.out.println("Name: " + university.getName());
        System.out.println("Established Date: " + university.getEstablishedDate());
        System.out.println(university.getUniversityInfo());

        university.setName("Tech University - Updated");
        university.setEstablishedDate(LocalDate.of(2020, 6, 15));

        System.out.println("\nUpdated University Information:");
        System.out.println("Name: " + university.getName());
        System.out.println("Established Date: " + university.getEstablishedDate());
        System.out.println(university.getUniversityInfo());

        System.out.println("\nTotal Number of Universities:");
        System.out.println(University.getUniversityCount());

        // Display departments and their courses
        System.out.println("\nDepartments:");

        for (Department dept : university.getDepartments()) {
            System.out.println("Department Name: " + dept.getDepartmentName());
            System.out.println("Courses:");

            for (Course course : dept.getCourses()) {
                System.out.println(course.getCourseName() + " - Credits: " + course.getCredits());
            }


            // Display and update professor details
            System.out.println("\nProfessor Details:");
            UniversityUtils.printMemberDetails(professor);

            System.out.println("\nOriginal Professor Name: " + professor.getName());
            System.out.println("Original Hire Date: " + professor.getHireDate());

            professor.setName("Dr. John Smith");
            professor.setHireDate(LocalDate.of(2022, 8, 22));

            System.out.println("\nUpdated Professor Details:");
            System.out.println(professor.getProfessorDetails(true));
            System.out.println("Updated Professor Name: " + professor.getName());
            System.out.println("Updated Hire Date: " + professor.getHireDate());

                        System.out.println("Professors:");
            for (Professor prof : dept.getProfessors()) {
                System.out.println(prof.getProfessorDetails(true));
            }
            // Override methods demonstration
            System.out.println("\nToString Override:");
            System.out.println(professor.toString());

            // Display and update student details and course registration
            System.out.println("\nStudent Details:");
            System.out.println("Original Name: " + student.getName());
            System.out.println("Original Enrollment Date: " + student.getEnrollmentDate());

            student.setName("Alice Johnson");
            student.setEnrollmentDate(LocalDate.of(2024, 10, 1));

            System.out.println("\nUpdated Student Details:");
            System.out.println("Updated Name: " + student.getName());
            System.out.println("Updated Enrollment Date: " + student.getEnrollmentDate());

            System.out.println("\nAll Students:");
            for (Student s : university.getStudents()) {
                System.out.println(s.getDetails());
            }


            // Display and update course details
            System.out.println("\nCourse Details:");
            System.out.println(javaCourse.getCourseName() + " - Credits: " + javaCourse.getCredits());

            javaCourse.setCourseName("Advanced Java Programming");
            javaCourse.setCredits(5);

            System.out.println("\nUpdated Course Details:");
            System.out.println(javaCourse.getCourseName() + " - Credits: " + javaCourse.getCredits());

            // Display detailed and basic course representation
            System.out.println("\nCourse Representation (Detailed):");
            System.out.println("Course Name: " + javaCourse.getCourseName() + ", Credits: " + javaCourse.getCredits());

            System.out.println("\nCourse Representation (Basic):");
            System.out.println(javaCourse.getCourseName());
        }
    }
}