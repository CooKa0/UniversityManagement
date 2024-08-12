package university.management;

public class Course {
    private String courseName;
    private int credits;

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseDetails() {
        return "Course Name: " + courseName + ", Credits: " + credits;
    }

//    public String toString(boolean detailed) {
//        if (detailed) {
//            return "Course Name: " + courseName + ", Credits: " + credits;
//        } else {
//            return courseName;
//        }
    }