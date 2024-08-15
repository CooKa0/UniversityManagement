package university.management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import university.personnel.Student;
import university.facilities.Classroom;
import university.facilities.Library;
import university.personnel.Worker;

public class University {
    private String name;
    private LocalDate establishedDate;
    private List<Department> departments;
    private List<Student> students;
    private List<Library> libraries;
    private List<Classroom> classrooms;
    private List<Worker> workers;
    private static int universityCount = 0;

    public University(String name, LocalDate establishedDate) {
        this.name = name;
        this.establishedDate = establishedDate;
        this.departments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.libraries = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.workers = new ArrayList<>();
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

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void addLibrary(Library library) {
        libraries.add(library);
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }


    public String getUniversityInfo() {
        return "University Name: " + name + ", Established: " + establishedDate;
    }

    public static int getUniversityCount() {
        return universityCount;
    }
}