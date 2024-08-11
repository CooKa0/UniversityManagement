package university.management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private LocalDate establishedDate;
    private List<Department> departments = new ArrayList<>();
    private static int universityCount = 0;

    public University(String name, LocalDate establishedDate) {
        this.name = name;
        this.establishedDate = establishedDate;
        universityCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public String getUniversityInfo() {
        return "University Name: " + name + ", Established: " + establishedDate;
    }

    public static int getUniversityCount() {
        return universityCount;
    }
}