package com.solvd.laba.university;

import com.solvd.laba.university.enums.*;
import com.solvd.laba.university.exceptions.ProfessorLimitExceededException;
import com.solvd.laba.university.management.*;
import com.solvd.laba.university.personnel.*;
import com.solvd.laba.university.facilities.*;
import com.solvd.laba.university.assessment.*;
import com.solvd.laba.university.utils.CustomLinkedList;
import com.solvd.laba.university.utils.ReflectionUtil;
import com.solvd.laba.university.utils.UniversityUtils;
import com.solvd.laba.university.utils.FileUtil;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.solvd.laba.university.enums.WorkerRole.*;

public class UniversityApp {

    private static final Logger logger = LogManager.getLogger(UniversityApp.class);



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define file paths
        String outputDir = System.getProperty("user.dir") + "/target/output/";
        String universityInfoFile = outputDir + "university_info.txt";
        String studentsInfoFile = outputDir + "students_info.txt";


        try {

            // Prompt the user to enter the university name
            System.out.print("Enter the name of the university: ");
            String universityName = scanner.nextLine();

            // Prompt the user to enter the founding date of the university
            int year = getValidYear(scanner);
            int month = getValidMonth(scanner);
            int day = getValidDay(scanner, year, month);

            // Create the university with the provided data
            University university = new University(universityName, LocalDate.of(year, month, day));

            System.out.println("University created successfully!");
            System.out.println("University Name: " + university.getName());
            System.out.println("Established Date: " + university.getEstablishedDate());

           // Create university
           //University university = new University("Tech University", LocalDate.of(2010, 1, 1));

            // Create department
            Department csDepartment = new Department("Computer Science");

            //test
            System.out.println("Course Levels:");
            UniversityUtils.getCourseLevels.get().forEach(level -> System.out.println(level.getLevelDescription()));


            // Create courses
            Course javaCourse = new Course("Java Programming", 4, CourseLevel.UNDERGRADUATE);
            Course dataStructuresCourse = new Course("Data Structures", 3, CourseLevel.UNDERGRADUATE);
            csDepartment.addCourse(javaCourse);
            csDepartment.addCourse(dataStructuresCourse);

            // Update the department name and add the department to the university
            csDepartment.setDepartmentName("Department of Computer Science");
            university.addDepartment(csDepartment);

            // Create a new student and register for courses
            Student student = new Student("Alice", LocalDate.of(2024, 9, 1));
            student.setId("S12345");
            university.addStudent(student);

            Course javaCourseToRegister = csDepartment.findCourseByName("Java Programming");
            Course dataStructuresCourseToRegister = csDepartment.findCourseByName("Data Structures");
            student.evaluate();
            student.trackProgress();

            // Register student for courses if found
                if (javaCourseToRegister != null) {
                    String registrationMessage1 = student.registerForCourse(javaCourseToRegister);
                    System.out.println("\nCourse Registration:");
                    System.out.println(registrationMessage1);
                } else {
                    System.out.println("Course 'Java Programming' not found!");
                }

                if (dataStructuresCourseToRegister != null) {
                    String registrationMessage2 = student.registerForCourse(dataStructuresCourseToRegister);
                    System.out.println(registrationMessage2);
                } else {
                    System.out.println("Course 'Data Structures' not found!");
                }

            // Display registered courses
            System.out.println("\nRegistered Courses:");
            student.getRegisteredCoursesList().stream()
                    .forEach(course -> System.out.println(course.getCourseName() + " - Status: Registered"));

            // Add grades and calculate GPA
            student.addCourseGrade(javaCourse, 3.7);
            student.addCourseGrade(dataStructuresCourse, 3.9);
            System.out.println("\nStudent GPA:");
            System.out.println("GPA: " + student.calculateGPA());

            // Add scholarship and convert currency
            student.setScholarshipAmount(1000.0);


            Currency targetCurrency = Currency.EUR;
            String formattedScholarship = student.convertAndFormatScholarship(targetCurrency);

            System.out.println("Converted scholarship: " + formattedScholarship);

            // Test the Consumer
            System.out.println("\nProfessor Levels:");
            UniversityUtils.printProfessorLevelDetails.accept(ProfessorLevel.FULL);
            UniversityUtils.printProfessorLevelDetails.accept(ProfessorLevel.ASSISTANT);

            // Create professor
            Professor professor = new Professor("Dr. Smith", LocalDate.of(2020, 5, 10), ProfessorLevel.FULL);
            try {
                csDepartment.addProfessor(professor);
            } catch (ProfessorLimitExceededException e) {
                System.err.println(e.getMessage());
            }

            // Get the list of courses from the department
            List<Course> departmentCourses = new ArrayList<>(csDepartment.getCourses().values());

            // Initialize managed courses for the professor
            Course courseToManage = csDepartment.findCourseByName("Java Programming");
            if (courseToManage != null) {
                professor.addCourse(courseToManage, departmentCourses);
            }


            // Demonstrate professor managing courses
            System.out.println("\nCourses managed by the Professor:");
            professor.listCourses(departmentCourses);

            // Display professor management details
            System.out.println("\nProfessor Management Details:");
            professor.manage();

            // Create classroom, library
            Classroom classroom = new Classroom("A101", 30);
            Library library1 = new Library("Main Library", 5000);
            Library library2 = new Library("Science Library", 3000);

            university.addClassroom(classroom);
            university.addLibrary(library1);
            university.addLibrary(library2);


            // Create new books
            Books book1 = new Books("Introduction to Algorithms", "Thomas H. Cormen", 2009, BookGenre.TEXTBOOK);
            Books book2 = new Books("Clean Code", "Robert C. Martin", 2008, BookGenre.PROFESSIONAL_DEVELOPMENT);

            // Add books to libraries
            library1.addBook(book1);
            library1.addBook(book2);

            // Check if genres are academic
            for (BookGenre genre : BookGenre.values()) {
                if (UniversityUtils.isAcademicGenre.test(genre)) {
                    System.out.println(genre.getGenreDescription() + " is an academic genre.");
                }
            }


            // Create an assignment and an exam
            Assignment assignment = new Assignment("Project 1", LocalDate.of(2024, 11, 15));
            assignment.setId("A001");
            assignment.setScore(85.0);

            Exam exam = new Exam("Final Exam", LocalDate.of(2024, 12, 15));
            student.addExam(exam, 90.0);
            // Evaluate student performance
            student.evaluate();

            // Track and print student progress
            student.trackProgress();
            System.out.println(student.getProgressReport());

            // Print assignment and exam details
            System.out.println("\nAssignments:");
            for (Assignment a : student.getAssignmentsList()) {
                double score = a.getScore();
                System.out.println(a.getAssignmentDetails() + " - Score: " + score);
            }

            System.out.println("\nExams:");
            for (Exam e : student.getExamsList()) {
                double score = e.getScore();
                System.out.println(e.getExamDetails(true) + " - Score: " + score);
            }

            // Print student ID
            System.out.println("\nStudent ID:");
            System.out.println(student.getId());


            // Create workers
            Worker janitor = new Worker("John Doe", LocalDate.of(2020, 6, 1), "Maintenance", 2000.00, 200.00, 15.00, 160, MAINTENANCE);
            Worker librarian = new Worker("Jane Smith", LocalDate.of(2018, 3, 15), "Library Services", 2500.00, 300.00, 20.00, 140, ADMINISTRATIVE);
            Worker securityGuard = new Worker("Alex Johnson", LocalDate.of(2021, 11, 1), "Security", 2200.00, 250.00, 18.00, 150, TECHNICAL);

            // Set IDs for workers
            janitor.setId("W001");
            librarian.setId("W002");
            securityGuard.setId("W003");

            // Add workers to the university
            university.addWorker(janitor);
            university.addWorker(librarian);
            university.addWorker(securityGuard);

            // Display worker IDs and details
            System.out.println("\nWorker Details:");
            for (Worker worker : university.getWorkers()) {
                System.out.println(worker.getDetails());
                System.out.println("Worker ID: " + worker.getId());
                System.out.println("Monthly Salary: " + worker.calculateSalary());
            }

            // Calculate and display average salary
            double averageSalary = UniversityUtils.calculateAverageSalary.apply(university.getWorkers());
            System.out.println("Average Salary of Workers: " + averageSalary);

            // Create events
            Events event1 = new Events("Annual Tech Conference", LocalDate.of(2024, 9, 20), "Scheduled");
            Events event2 = new Events("Semester Start", LocalDate.of(2024, 9, 1), "Scheduled");

            // Add events to the department
            csDepartment.addEvent(event1);
            csDepartment.addEvent(event2);

            // Display events in the department
            System.out.println("\nEvents in the Department:");
            CustomLinkedList<Events> eventsList = csDepartment.getEvents();
            for (int i = 0; i < eventsList.size(); i++) {
                Events event = eventsList.get(i);
                System.out.println(event);
            }

            System.out.println("\nTotal Events in the Department: " + csDepartment.getEventCount());
            System.out.println("Are there any events? " + (csDepartment.areEventsEmpty() ? "No" : "Yes"));

            // Clear events
            System.out.print("Do you want to clear all events? (yes/no): ");
            String clearEventsResponse = scanner.nextLine();
            if (clearEventsResponse.equalsIgnoreCase("yes")) {
                csDepartment.clearEvents();
                System.out.println("All events have been cleared.");
            }

            // Adding a collection of events
            CustomLinkedList<Events> newEvents = new CustomLinkedList<>();
            newEvents.add(new Events("New Faculty Orientation", LocalDate.of(2024, 8, 15), "Scheduled"));
            newEvents.add(new Events("Final Exam Review", LocalDate.of(2024, 12, 10), "Scheduled"));


            // Demonstrate event management
            System.out.println("\nDemonstrating Event Management by Worker:");
            janitor.createEvent();
            janitor.organizeEvent();
            janitor.modifyEvent();
            janitor.cancelEvent();

            // Display updated events in the department after worker operations
            System.out.println("\nUpdated Events in the Department:");
                for (int i = 0; i < eventsList.size(); i++) {
                    Events event = eventsList.get(i);
                    System.out.println(event);
            }

            // Remove an event from the department
                int indexToRemove = 1;
                csDepartment.removeEvent(indexToRemove);

            System.out.println("\nEvents in the Department After Removal:");
                for (int i = 0; i < eventsList.size(); i++) {
                    Events event = eventsList.get(i);
                    System.out.println(event);
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

            // Filter classrooms based on capacity
            List<Classroom> classroomList = Arrays.asList(university.getClassrooms());
            List<Classroom> filteredClassrooms = UniversityUtils.filterByCapacity(30).apply(classroomList);
            System.out.println("\nFiltered Classrooms (Capacity <= 30):");
            for (Classroom cls : filteredClassrooms) {
                System.out.println(cls.getClassroomInfo());
            }

            // Display library information
            System.out.println("\nLibraries:");
            for (Library lib : university.getLibraries()) {
                System.out.println("Library Name: " + lib.getLibraryName());
                System.out.println("Number of Books: " + lib.getBookCount());
                System.out.println("Library Info: " + lib.getLibraryInfo());
            }

            // Update library names
            library1.setLibraryName("Updated Main Library");
            library2.setLibraryName("Updated Science Library");

            // Create new books
            Books newBook = new Books("Effective Java", "Joshua Bloch", 2018, BookGenre.TEXTBOOK);

            // Adding Books with Details
            System.out.println("\nAdding book: " + newBook.getBookDetails());
            library1.addBook(newBook);

            // Update Book Information
            newBook.setTitle("Effective Java (3rd Edition)");
            newBook.setAuthor("Joshua Bloch");
            newBook.setYearPublished(2019);
            newBook.setAvailable(false);
            System.out.println("Updated book details: " + newBook.getBookDetails());

            // Display and update library information
            System.out.println("\nLibrary Information:");
            System.out.println(library1.getLibraryInfo());
            System.out.println(library2.getLibraryInfo());


    //        // List all books in each library
    //        System.out.println("\nBooks in Libraries:");
    //        for (Library lib : university.getLibraries()) {
    //            System.out.println("\nLibrary: " + lib.getLibraryName());
    //            for (Books book : lib.getBooksList()) {
    //                System.out.println(book.getBookDetails());
    //            }
    //        }

            // Check Availability
            if (newBook.isAvailable()) {
                System.out.println("The book is available for checkout.");
            } else {
                System.out.println("The book is currently checked out.");
            }

            // Remove Books
            library1.removeBook(newBook);
            System.out.println("Removed book: " + newBook.getBookDetails());
            System.out.println("Updated Library 1 Information:");
            System.out.println(library1.getLibraryInfo());
            System.out.println("Total Books Across All Libraries: " + Library.getTotalBooksAcrossAllLibraries());

            // Display all libraries
            System.out.println("\nLibraries:");
            for (Library lib : university.getLibraries()) {
                System.out.println(lib.getLibraryInfo());
            }

            // Display department information
            System.out.println("\nDepartment Information:");
            System.out.println("Department Name: " + csDepartment.getDepartmentName());

            System.out.println("Courses with Credits:");
            for (Course course : csDepartment.getCourses().values()) {
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

            for (Course course : dept.getCourses().values()) {
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
            System.out.println(professor);

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
            System.out.println(javaCourse.getCourseDetails());

            javaCourse.setCourseName("Advanced Java Programming");
            javaCourse.setCredits(5);

            System.out.println("\nUpdated Course Details:");
            System.out.println(javaCourse.getCourseDetails());

            // Display detailed and basic course representation
            System.out.println("\nCourse Representation (Detailed):");
            System.out.println(javaCourse.getCourseDetails(true));

            System.out.println("\nCourse Representation (Basic):");
            System.out.println(javaCourse.getCourseDetails(false));

            // Print details of each worker
            System.out.println("\nWorker Details:");
            for (Worker worker : university.getWorkers()) {
                System.out.println(worker.getDetails());
            }

            // Update and display worker details
            System.out.println("\nUpdating Worker Details:");
            janitor.setName("Johnathan Doe");
            janitor.setHireDate(LocalDate.of(2019, 12, 15));
            janitor.setDepartment("Facilities");

            System.out.println("Updated Department: " + janitor.getDepartment());
            System.out.println(janitor.getDetails());


            // Demonstrate overridden toString method
            System.out.println("\nToString Override:");
            System.out.println(janitor);

            System.out.println("\nComparing a Student and a Professor:");
            UniversityUtils.compareMembers(student, professor);

            System.out.println("\nComparing Two Workers:");
            UniversityUtils.compareMembers(janitor, librarian);

            }


            // Write university information to file
            StringBuilder universityInfoBuilder = new StringBuilder();
            universityInfoBuilder.append("University Name: ").append(university.getName()).append("\n");
            universityInfoBuilder.append("Established Date: ").append(university.getEstablishedDate()).append("\n");
            universityInfoBuilder.append("Departments:\n");

            for (Department dept : university.getDepartments()) {
                universityInfoBuilder.append("  Department Name: ").append(dept.getDepartmentName()).append("\n");
                universityInfoBuilder.append("  Courses:\n");
                for (Course course : dept.getCourses().values()) {
                    universityInfoBuilder.append("    ").append(course.getCourseName()).append(" - Credits: ").append(course.getCredits()).append("\n");
                }
            }

            try {
                FileUtil.writeFile(universityInfoFile, universityInfoBuilder.toString());
            } catch (Exception e) {
                logger.error("Failed to write university information to file: {}", universityInfoFile, e);
            }

                try {
                    FileUtil.writeFile(universityInfoFile, universityInfoBuilder.toString());
                } catch (Exception e) {
                    logger.error("Failed to write university information to file: {}", universityInfoFile, e);
                }

            // Write student information to file
            StringBuilder studentsInfoBuilder = new StringBuilder();
            studentsInfoBuilder.append("Students:\n");
            for (Student s : university.getStudents()) {
                studentsInfoBuilder.append(s.getDetails()).append("\n");
            }

            try {
                FileUtil.writeFile(studentsInfoFile, studentsInfoBuilder.toString());
            } catch (Exception e) {
                logger.error("Failed to write student information to file: {}", studentsInfoFile, e);
            }


            // Read university information from file
            String universityInfoFromFile;
            try {
                universityInfoFromFile = FileUtil.readFile(universityInfoFile);
                System.out.println("University Information from File:");
                System.out.println(universityInfoFromFile);
            } catch (Exception e) {
                logger.error("Failed to read university information from file.", e);
            }

            // Read student information from file
            String studentsInfoFromFile;
            try {
                studentsInfoFromFile = FileUtil.readFile(studentsInfoFile);
                System.out.println("Students Information from File:");
                System.out.println(studentsInfoFromFile);
            } catch (Exception e) {
                logger.error("Failed to read student information from file.", e);
            }

            //Extracting information about the Professor class
            System.out.println("Reflection on Professor class:");
            ReflectionUtil.printClassInfo(Professor.class);


            //Creating an instance of Professor using reflection
            System.out.println("\nCreating an instance of Professor:");
            Object professorInstance = ReflectionUtil.createInstance(
                    Professor.class,
                    new Class[]{String.class, LocalDate.class, ProfessorLevel.class},
                    "John Doe", LocalDate.now(), ProfessorLevel.ASSISTANT
            );
            System.out.println("Instance created: " + professorInstance);

            //Calling a method on the Professor instance using reflection
            Object result = ReflectionUtil.callMethod(professorInstance, "getProfessorDetails", new Class[]{boolean.class}, true);
            System.out.println("Method result: " + result);

        } catch (Exception e) {
            logger.error("Error: ", e);
        }
        logger.info("University app finished.");

    }

    private static int getValidYear(Scanner scanner) {
        int year;
        while (true) {
            System.out.print("Enter the year of establishment: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year < 1000 || year > LocalDate.now().getYear()) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid 4-digit year.");
            }
        }
        return year;
    }

    private static int getValidMonth(Scanner scanner) {
        int month;
        while (true) {
            System.out.print("Enter the month of establishment (1-12): ");
            try {
                month = Integer.parseInt(scanner.nextLine());
                if (month < 1 || month > 12) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid month. Please enter a month between 1 and 12.");
            }
        }
        return month;
    }

    private static int getValidDay(Scanner scanner, int year, int month) {
        int day;
        while (true) {
            System.out.print("Enter the day of establishment (1-31): ");
            try {
                day = Integer.parseInt(scanner.nextLine());
                if (day < 1 || day > 31) {
                    throw new NumberFormatException("Day out of range (1-31).");
                }
                LocalDate date = LocalDate.of(year, month, 1);
                int maxDay = date.lengthOfMonth();
                if (day > maxDay) {
                    throw new NumberFormatException("Invalid day for the specified month.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid day. Please enter a day between 1 and 31.");
            } catch (DateTimeException e) {
                System.out.println("Invalid date. Please ensure the day, month, and year are correct.");
            }
        }
        return day;
    }
}