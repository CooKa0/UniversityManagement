package com.solvd.laba.university.enums;

import java.util.Arrays;

public enum BookGenre {
    TEXTBOOK("Textbook"),
    RESEARCH("Research"),
    JOURNAL("Journal"),
    ACADEMIC("Academic"),
    LITERATURE("Literature"),
    THESIS("Thesis"),
    PROFESSIONAL_DEVELOPMENT("Professional Development");

    private final String genreDescription;

    BookGenre(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public boolean isAcademic() {
        return this == TEXTBOOK || this == RESEARCH || this == JOURNAL || this == THESIS;
    }

    static {
        System.out.println("Available Book Genres:");
        Arrays.stream(BookGenre.values())
                .map(BookGenre::getGenreDescription)
                .forEach(System.out::println);
        }
    }