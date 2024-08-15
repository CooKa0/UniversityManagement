package university.personnel;

import java.time.LocalDate;


public class Professor extends UniversityMember {

    public Professor(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public String getDetails() {
        return "Professor: " + name + ", Hired on: " + hireDate;
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
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}