package university.personnel;

import java.time.LocalDate;

public class Worker extends UniversityMember {
    private String department;

    public Worker(String name, LocalDate hireDate, String department) {
        super(name, hireDate);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "Worker";
    }

    @Override
    public String getDetails() {
        return "Worker: " + name + ", Department: " + department + ", Hired on: " + hireDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + department.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Worker worker = (Worker) obj;

        return department.equals(worker.department);
    }
}