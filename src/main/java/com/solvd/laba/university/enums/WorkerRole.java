package com.solvd.laba.university.enums;

import java.util.Arrays;

public enum WorkerRole {
    ADMINISTRATIVE("Administrative staff, handling office tasks."),
    ACADEMIC("Academic staff, involved in teaching and research."),
    TECHNICAL("Technical staff, supporting IT and technical operations."),
    MAINTENANCE("Maintenance staff, responsible for facilities upkeep."),
    RESEARCH("Research staff, focused on academic research projects.");

    private final String description;


    WorkerRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getRoleDetails() {
        return name() + ": " + description;
    }

    static {
        System.out.println("\nAvailable Worker Roles:");
        Arrays.stream(WorkerRole.values())
                .map(WorkerRole::getRoleDetails)
                .forEach(System.out::println);
    }
}