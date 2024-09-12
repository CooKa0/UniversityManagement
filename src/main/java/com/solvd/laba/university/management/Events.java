package com.solvd.laba.university.management;

import java.time.LocalDate;

public class Events {
    private String name;
    private LocalDate date;
    private String status;

    public Events(String name, LocalDate date, String status) {
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean conflictsWith(Events otherEvent) {
        return this.date.equals(otherEvent.date);
    }

    @Override
    public String toString() {
        return "Events{Name='" + name + "', Date=" + date + ", Status='" + status + "'}";
    }
}