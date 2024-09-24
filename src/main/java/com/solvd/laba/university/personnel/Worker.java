package com.solvd.laba.university.personnel;

import com.solvd.laba.university.interfaces.EventOrganizable;
import com.solvd.laba.university.interfaces.Identifiable;
import com.solvd.laba.university.management.Events;
import com.solvd.laba.university.enums.WorkerRole;
import com.solvd.laba.university.utils.CurrencyUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Worker extends UniversityMember implements EventOrganizable, Identifiable  {
    private String department;
    private String id;
    private List<Events> events;

    private double baseSalary;
    private double bonus;
    private double hourlyRate;
    private int hoursWorked;
    private static final int STANDARD_WORK_HOURS = 160;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private WorkerRole role;

    public Worker(String name, LocalDate hireDate, String department, double baseSalary, double bonus, double hourlyRate, int hoursWorked, WorkerRole role) {
        super(name, hireDate);
        this.department = department;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.role = role;
    }

    private List<Events> getOrCreateEvents() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events;
    }

    public double calculateSalary() {
        double totalSalary = baseSalary + bonus;

        if (hoursWorked > STANDARD_WORK_HOURS) {
            int overtimeHours = hoursWorked - STANDARD_WORK_HOURS;
            double overtimePay = overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;
            totalSalary += overtimePay;
        } else {
            totalSalary += hoursWorked + hourlyRate;
        }

        return  totalSalary;
    }


    @Override
    public String getRole() {
        return role.name();
    }

    @Override
    public String getDetails() {
        return "Worker: " + name + ", Department: " + department + ", Role: " + role + ", Hired on: " + hireDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department + ", Role: " + role;
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void organizeEvent() {
        List<Events> events = getOrCreateEvents();
        System.out.println("Organizing all events...");
        events.stream()
                .peek(event -> event.setStatus("Organized"))
                .forEach(System.out::println);
    }

    @Override
    public void cancelEvent() {
        List<Events> events = getOrCreateEvents();
        System.out.println("Canceling all events...");
        events.stream()
                .peek(event -> event.setStatus("Canceled"))
                .forEach(System.out::println);
    }

    @Override
    public void createEvent() {
        List<Events> events = getOrCreateEvents();
        Events newEvent = new Events("New Event", LocalDate.now().plusDays(7), "Scheduled");
        events.add(newEvent);
        System.out.println("Created new event: " + newEvent);
    }

    @Override
    public void modifyEvent() {
        List<Events> events = getOrCreateEvents();
        if (events.isEmpty()) {
            System.out.println("No events to modify.");
            return;
        }
        // Update the status of the first event
        Events eventToModify = events.get(0);
        eventToModify.setStatus("Modified");
        System.out.println("Modified event: " + eventToModify);
    }

    public List<Events> getEvents() {
        return getOrCreateEvents();
    }
}