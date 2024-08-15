package university.utils;

import university.personnel.UniversityMember;

// Utility Class
public class UniversityUtils {
    public static void printMemberDetails(UniversityMember member) {
        System.out.println("Member Details:");
        System.out.println(member.getDetails());
    }

    public static void compareMembers(UniversityMember member1, UniversityMember member2) {
        System.out.println("Comparing Members:");
        System.out.println("Are members equal? " + member1.equals(member2));
    }
}