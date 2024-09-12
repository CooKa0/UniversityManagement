package com.solvd.laba.university.management;

import java.time.LocalDate;
import com.solvd.laba.university.personnel.Student;
import com.solvd.laba.university.facilities.Classroom;
import com.solvd.laba.university.facilities.Library;
import com.solvd.laba.university.personnel.Worker;


public class University {
    private String name;
    private LocalDate establishedDate;
    private Department[] departments;
    private Student[] students;
    private Library[] libraries;
    private Classroom[] classrooms;
    private Worker[] workers;
    private static int universityCount;

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

    public Department[] getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        if (departments == null) {
            departments = new Department[1];
            departments[0] = department;
        } else {
            Department[] temp = new Department[departments.length + 1];
            System.arraycopy(departments, 0, temp, 0, departments.length);
            temp[departments.length] = department;
            departments = temp;
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new Student[1];
            students[0] = student;
        } else {
            Student[] temp = new Student[students.length + 1];
            System.arraycopy(students, 0, temp, 0, students.length);
            temp[students.length] = student;
            students = temp;
        }
    }

    public Library[] getLibraries() {
        return libraries;
    }

    public void addLibrary(Library library) {
        if (libraries == null) {
            libraries = new Library[1];
            libraries[0] = library;
        } else {
            Library[] temp = new Library[libraries.length + 1];
            System.arraycopy(libraries, 0, temp, 0, libraries.length);
            temp[libraries.length] = library;
            libraries = temp;
        }
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }

    public void addClassroom(Classroom classroom) {
        if (classrooms == null) {
            classrooms = new Classroom[1];
            classrooms[0] = classroom;
        } else {
            Classroom[] temp = new Classroom[classrooms.length + 1];
            System.arraycopy(classrooms, 0, temp, 0, classrooms.length);
            temp[classrooms.length] = classroom;
            classrooms = temp;
        }
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        if (workers == null) {
            workers = new Worker[1];
            workers[0] = worker;
        } else {
            Worker[] temp = new Worker[workers.length + 1];
            System.arraycopy(workers, 0, temp, 0, workers.length);
            temp[workers.length] = worker;
            workers = temp;
        }
    }

    public String getUniversityInfo() {
        return "University Name: " + name + ", Established: " + establishedDate;
    }

    public static int getUniversityCount() {
        return universityCount;
    }
}