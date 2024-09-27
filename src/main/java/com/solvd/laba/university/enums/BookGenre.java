package com.solvd.laba.university.enums;

import java.util.Arrays;
import java.util.EnumSet;

public enum BookGenre {
    TEXTBOOK("Textbook"),
    RESEARCH("Research"),
    JOURNAL("Journal"),
    ACADEMIC("Academic"),
    LITERATURE("Literature"),
    THESIS("Thesis"),
    PROFESSIONAL_DEVELOPMENT("Professional Development");

    private final String genreDescription;

    //define set for academic genres
    private static final EnumSet<BookGenre> ACADEMIC_GENRES = EnumSet.of(TEXTBOOK, RESEARCH, JOURNAL, THESIS);

    BookGenre(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public boolean isAcademic() {
        return ACADEMIC_GENRES.contains(this);
    }

    static {
        System.out.println("Available Book Genres:");
        Arrays.stream(BookGenre.values())
                .map(BookGenre::getGenreDescription)
                .forEach(System.out::println);
        }
    }