package university.personnel;

import java.time.LocalDate;

public abstract class UniversityMember {
    protected String name;
    protected LocalDate enrollmentDate;

    public UniversityMember(String name, LocalDate enrollmentDate) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public abstract String getRole();

    public abstract String getDetails();

    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + getRole();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + enrollmentDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UniversityMember that = (UniversityMember) obj;

        return name.equals(that.name) && enrollmentDate.equals(that.enrollmentDate);
    }
}