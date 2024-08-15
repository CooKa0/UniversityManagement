package university.personnel;

import java.time.LocalDate;

// Professor class extends UniversityMember
public class Professor extends UniversityMember {
    private LocalDate hireDate;

    public Professor(String name, LocalDate hireDate) {
        super(name, hireDate);
        this.hireDate = hireDate;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public String getDetails() {
        return "Professor: " + name + ", Hired on: " + hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getProfessorDetails(boolean includeHireDate) {
        if (includeHireDate) {
            return "Professor Name: " + name + ", Hire Date: " + hireDate;
        } else {
            return "Professor Name: " + name;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Hire Date: " + hireDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + hireDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Professor professor = (Professor) obj;

        return hireDate.equals(professor.hireDate);
    }
}