package com.solvd.laba.university.exceptions;

public class LibraryFullException extends RuntimeException {
    public LibraryFullException(String message) {
        super(message);
    }
}