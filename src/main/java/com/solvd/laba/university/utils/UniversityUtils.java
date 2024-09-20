package com.solvd.laba.university.utils;

import com.solvd.laba.university.enums.BookGenre;
import com.solvd.laba.university.enums.CourseLevel;
import com.solvd.laba.university.enums.ProfessorLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import com.solvd.laba.university.personnel.Student;
import com.solvd.laba.university.personnel.Professor;
import com.solvd.laba.university.personnel.Worker;
import com.solvd.laba.university.personnel.UniversityMember;
import com.solvd.laba.university.facilities.Classroom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UniversityUtils {

        private static final Logger logger = LogManager.getLogger(UniversityUtils.class);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //can use switch statements too
        public static void printMemberDetails(UniversityMember member) {
            System.out.println("Member Details:");
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(StringUtils.defaultString(student.getDetails(), "No details available."));
                System.out.println("GPA: " + student.calculateGPA());
            } else if (member instanceof Professor) {
                Professor professor = (Professor) member;
                System.out.println(StringUtils.defaultString(professor.getDetails(), "No details available."));
            } else if (member instanceof Worker) {
                Worker worker = (Worker) member;
                System.out.println(StringUtils.defaultString(worker.getDetails(), "No details available."));
            } else {
                System.out.println(StringUtils.defaultString(member.getDetails(), "No details available."));
            }
        }

        public static void compareMembers(UniversityMember member1, UniversityMember member2) {
            logger.info("Comparing Members:");
            boolean areEqual = member1.equals(member2);
            logger.info("Are members equal? " + areEqual);

            logger.info("Details of Member 1:");
            printSpecificDetails(member1);

            logger.info("Details of Member 2:");
            printSpecificDetails(member2);
        }

        public static void printSpecificDetails(UniversityMember member) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println("Name: " + StringUtils.defaultString(student.getName(), "Unknown"));
                System.out.println("Role: " + StringUtils.defaultString(student.getRole(), "Unknown"));
                System.out.println("Enrollment Date: " + formatDate(student.getEnrollmentDate()));
                System.out.println("GPA: " + student.calculateGPA());
                System.out.println("Trimmed Name: '" + StringUtils.trim(student.getName()) + "'");
                System.out.println("Uppercase Name: " + StringUtils.upperCase(student.getName()));
            } else if (member instanceof Professor) {
                Professor professor = (Professor) member;
                System.out.println("Name: " + StringUtils.defaultString(professor.getName(), "Unknown"));
                System.out.println("Role: " + StringUtils.defaultString(professor.getRole(), "Unknown"));
                System.out.println("Hire Date: " + formatDate(professor.getHireDate()));
                System.out.println("Reversed Role: " + StringUtils.reverse(professor.getRole()));
                System.out.println("Is Name Empty: " + StringUtils.isEmpty(professor.getName()));
            } else if (member instanceof Worker) {
                Worker worker = (Worker) member;
                System.out.println("Name: " + StringUtils.defaultString(worker.getName(), "Unknown"));
                System.out.println("Role: " + StringUtils.defaultString(worker.getRole(), "Unknown"));
                System.out.println("Hire Date: " + formatDate(worker.getHireDate()));
                System.out.println("Name Length: " + StringUtils.length(worker.getName()));
                System.out.println("Lowercase Name: " + StringUtils.lowerCase(worker.getName()));
            } else {
                System.out.println("Name: " + StringUtils.defaultString(member.getName(), "Unknown"));
                System.out.println("Role: " + StringUtils.defaultString(member.getRole(), "Unknown"));
            }
        }

        private static String formatDate(LocalDate date) {
            return (date != null) ? date.format(dateFormatter) : "Unknown";
        }

        // Predicate to check if a genre is academic
        public static Predicate<BookGenre> isAcademicGenre = genre -> genre.isAcademic();

        // Lambda for calculating average salary
        public static Function<Worker[], Double> calculateAverageSalary = workers -> {
            return Arrays.stream(workers)
                    .map(Worker::calculateSalary)
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
        };

        // Supplier for Course Levels
        public static Supplier<List<CourseLevel>> getCourseLevels = () -> Arrays.asList(CourseLevel.values());

        // Consumer for Professor Levels
        public static Consumer<ProfessorLevel> printProfessorLevelDetails = level -> {
            System.out.println(level.getDetails());
        };

        // Custom lambda function for filtering classrooms based on a capacity threshold
        public static <T extends Classroom> Function<List<T>, List<T>> filterByCapacity(int capacityThreshold) {
            return classrooms -> classrooms.stream()
                    .filter(classroom -> classroom.getCapacity() <= capacityThreshold)
                    .toList();
        }
    }