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

    public String getCourseDetails(boolean detailed) {
        if (detailed) {
            return "Course Name: " + courseName + ", Credits: " + credits;
        } else {
            return "Course Name: " + courseName;
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public int hashCode() {
        return courseName.hashCode() + credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Course that = (Course) obj;
        return credits == that.credits && courseName.equals(that.courseName);
    }
}
