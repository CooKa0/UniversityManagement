package com.solvd.laba.university.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import com.solvd.laba.university.personnel.Student;
import com.solvd.laba.university.personnel.Professor;
import com.solvd.laba.university.personnel.Worker;
import com.solvd.laba.university.personnel.UniversityMember;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    }