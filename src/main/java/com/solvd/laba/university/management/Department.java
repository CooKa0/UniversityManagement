package com.solvd.laba.university.management;

import java.util.*;

import com.solvd.laba.university.exceptions.CourseNotFoundException;
import com.solvd.laba.university.exceptions.EventConflictException;
import com.solvd.laba.university.exceptions.ProfessorLimitExceededException;
import com.solvd.laba.university.personnel.Professor;
import com.solvd.laba.university.utils.CustomLinkedList;


public class Department {
    private String departmentName;
    //using map to manage courses
    private Map<String, Course> courses;
    //using set to avoid duplicating professors
    private Set<Professor> professors;
    private CustomLinkedList<Events> events;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Map<String, Course> getCourses() {
        if (courses == null) {
            // Use HashMap for dynamic sizing and efficient lookups
            courses = new HashMap<>();
        }
        return courses;
    }

    public void addCourse(Course course) {
        getCourses().put(course.getCourseName(), course);
    }

    public Set<Professor> getProfessors() {
        if (professors == null) {
            // Use HashSet to ensure no duplicate professors
            professors = new HashSet<>();
        }
        return professors;
    }

    public void addProfessor(Professor professor) throws ProfessorLimitExceededException {
        if (getProfessors().size() >= UniversityConstants.MAX_PROFESSORS_PER_DEPARTMENT) {
            throw new ProfessorLimitExceededException("Cannot add more professors. Maximum limit reached.");
        }
        getProfessors().add(professor);
    }

    public CustomLinkedList<Events> getEvents() {
        if (events == null) {
            events = new CustomLinkedList<>();
        }
        return events;
    }

    public int getEventCount() {
        return getEvents().size();
    }

    public boolean areEventsEmpty() {
        return getEvents().isEmpty();
    }

    public void clearEvents() {
        getEvents().clear();
    }

    public void addEvent(Events newEvent) throws EventConflictException {
        Events[] eventsArray = getEvents().toArray(new Events[0]);
        for (Events event : eventsArray) {
            if (event != null && event.conflictsWith(newEvent)) {
                throw new EventConflictException("Event conflicts with existing event: " + event.getName());
            }
        }
        getEvents().add(newEvent);
    }

    public void removeEvent(int index) {
        if (events != null && index >= 0 && index < events.size()) {
            getEvents().remove(index);
        }
    }

    public String listCourses() {
        StringBuilder courseList = new StringBuilder();
        for (Course course : getCourses().values()) {
            courseList.append(course.getCourseName()).append("\n");
        }
        return courseList.toString();
    }

    public String listCourses(boolean detailed) {
        StringBuilder courseList = new StringBuilder();
        for (Course course : getCourses().values()) {
            if (detailed) {
                courseList.append("Course Name: ").append(course.getCourseName())
                        .append(", Credits: ").append(course.getCredits())
                        .append("\n");
            } else {
                courseList.append(course.getCourseName()).append("\n");
            }
        }
        return courseList.toString();
    }

    public Course findCourseByName(String courseName) throws CourseNotFoundException {
        Course course = getCourses().get(courseName);
        if (course == null) {
            throw new CourseNotFoundException("Course with name " + courseName + " not found.");
        }
        return course;
    }

    @Override
    public int hashCode() {
        return departmentName.hashCode() + (courses != null ? courses.hashCode() : 0) + (professors != null ? professors.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Department that = (Department) obj;
        return departmentName.equals(that.departmentName) &&
                (courses != null ? courses.equals(that.courses) : that.courses == null) &&
                (professors != null ? professors.equals(that.professors) : that.professors == null);
    }
}