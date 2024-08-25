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

    static {
        System.out.println("University class loaded. Initializing static variables...");
    }

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
        if (departments == null) {
            departments = new ArrayList<>();
        }
        return departments;
    }

    public void addDepartment(Department department) {
        if (departments == null) {
            departments = new ArrayList<>();
        }
        departments.add(department);
    }

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public List<Library> getLibraries() {
        if (libraries == null) {
            libraries = new ArrayList<>();
        }
        return libraries;
    }

    public void addLibrary(Library library) {
        if (libraries == null) {
            libraries = new ArrayList<>();
        }
        libraries.add(library);
    }

    public List<Classroom> getClassrooms() {
        if (classrooms == null) {
            classrooms = new ArrayList<>();
        }
        return classrooms;
    }

    public void addClassroom(Classroom classroom) {
        if (classrooms == null) {
            classrooms = new ArrayList<>();
        }
        classrooms.add(classroom);
    }

    public List<Worker> getWorkers() {
        if (workers == null) {
            workers = new ArrayList<>();
        }
        return workers;
    }

    public void addWorker(Worker worker) {
        if (workers == null) {
            workers = new ArrayList<>();
        }
        workers.add(worker);
    }

    public String getUniversityInfo() {
        return "University Name: " + name + ", Established: " + establishedDate;
    }

    public static int getUniversityCount() {
        return universityCount;
    }
}