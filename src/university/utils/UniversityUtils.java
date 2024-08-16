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
        if (areEqual) {
            System.out.println("Details of Member 1: " + member1);
            System.out.println("Details of Member 2: " + member2);
        } else {
            System.out.println("Details of Member 1: " + member1);
            System.out.println("Details of Member 2: " + member2);
        }
    }
}