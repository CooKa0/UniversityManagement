package com.solvd.laba.university.personnel;

import java.time.LocalDate;

public abstract class UniversityMember {
    protected String name;
    protected LocalDate hireDate;

    public UniversityMember(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public UniversityMember(String name) {
        this.name = name;
        this.hireDate = null;
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

    public abstract String getRole();

    public abstract String getDetails();


    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + getRole() + ", Hire Date: " + hireDate;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + hireDate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UniversityMember that = (UniversityMember) obj;

        return name.equals(that.name) && hireDate.equals(that.hireDate);
    }
}