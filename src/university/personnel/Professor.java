package university.personnel;

import java.time.LocalDate;

public class Professor {
    private String name;
    private LocalDate hireDate;

    public Professor(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getProfessorDetails() {
        return "Professor: " + name + ", Hired on: " + hireDate;
    }

    public String getProfessorDetails(boolean includeHireDate) {
        if (includeHireDate) {
            return getProfessorDetails();
        } else {
            return "Professor: " + name;
        }
    }
}