package university.utils;

import university.personnel.Student;
import university.personnel.Professor;
import university.personnel.Worker;
import university.personnel.UniversityMember;

public class UniversityUtils {

    //can use switch statement too
    public static void printMemberDetails(UniversityMember member) {
        System.out.println("Member Details:");
        if (member instanceof Student) {
            Student student = (Student) member;
            System.out.println(student.getDetails());
            System.out.println("GPA: " + student.calculateGPA());
        } else if (member instanceof Professor) {
            Professor professor = (Professor) member;
            System.out.println(professor.getDetails());
        } else if (member instanceof Worker) {
            Worker worker = (Worker) member;
            System.out.println(worker.getDetails());
        } else {
            System.out.println(member.getDetails());
        }
    }

    public static void compareMembers(UniversityMember member1, UniversityMember member2) {
        System.out.println("Comparing Members:");
        boolean areEqual = member1.equals(member2);
        System.out.println("Are members equal? " + areEqual);

        System.out.println("Details of Member 1:");
        printSpecificDetails(member1);

        System.out.println("Details of Member 2:");
        printSpecificDetails(member2);
    }

    private static void printSpecificDetails(UniversityMember member) {
        if (member instanceof Student) {
            Student student = (Student) member;
            System.out.println("Name: " + student.getName());
            System.out.println("Role: " + student.getRole());
            System.out.println("Enrollment Date: " + student.getEnrollmentDate());
            System.out.println("GPA: " + student.calculateGPA());
        } else if (member instanceof Professor) {
            Professor professor = (Professor) member;
            System.out.println("Name: " + professor.getName());
            System.out.println("Role: " + professor.getRole());
            System.out.println("Hire Date: " + professor.getHireDate());
        } else if (member instanceof Worker) {
            Worker worker = (Worker) member;
            System.out.println("Name: " + worker.getName());
            System.out.println("Role: " + worker.getRole());
            System.out.println("Hire Date: " + worker.getHireDate());
        } else {
            System.out.println("Name: " + member.getName());
            System.out.println("Role: " + member.getRole());
        }
    }
}