package com.solvd.laba.university.facilities;

import com.solvd.laba.university.management.UniversityConstants;

public class Classroom {
    private String roomNumber;
    private int capacity;

    public Classroom(String roomNumber, int capacity) {
        if (capacity > UniversityConstants.MAX_STUDENTS_PER_CLASS) {
            throw new IllegalArgumentException("Capacity cannot exceed " + UniversityConstants.MAX_STUDENTS_PER_CLASS);
        }
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassroomInfo() {
        return "Room Number: " + roomNumber + ", Capacity: " + capacity;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public int hashCode() {
        return roomNumber.hashCode() + capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Classroom that = (Classroom) obj;
        return capacity == that.capacity && roomNumber.equals(that.roomNumber);
    }
}