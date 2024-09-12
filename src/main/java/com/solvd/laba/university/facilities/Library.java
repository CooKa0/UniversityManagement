package com.solvd.laba.university.facilities;

import com.solvd.laba.university.exceptions.LibraryFullException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private int bookCount;
    private List<Books> booksList;

    private static final int MAX_BOOKS = 10000;
    private static int totalBooksAcrossAllLibraries;

    public Library(String libraryName, int initialBookCount) {
        this.libraryName = libraryName;
        this.bookCount = initialBookCount;

        if (initialBookCount > MAX_BOOKS) {
            throw new IllegalArgumentException("Initial book count exceeds the maximum allowed.");
        }

        if (initialBookCount > 0) {
            this.booksList = new ArrayList<>();
            for (int i = 0; i < initialBookCount; i++) {
                booksList.add(new Books("Book" + (i + 1), "Author" + (i + 1), 2020 + (i % 5)));
            }
        }
        totalBooksAcrossAllLibraries += initialBookCount;
    }


    // Adds a book to the current library and updates the global book count
    public void addBook(Books book) {
        if (bookCount >= MAX_BOOKS) {
            throw new LibraryFullException("Cannot add more books. Maximum limit reached.");
        }
        booksList.add(book);
        bookCount++;
        totalBooksAcrossAllLibraries++;
    }

    // Removes a book from the current library and updates the global book count
    public void removeBook(Books book) {
        if (booksList.remove(book)) {
            bookCount--;
            totalBooksAcrossAllLibraries--;
        }
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getBookCount() {
        return bookCount;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    // Returns the total number of books across all libraries
    public static int getTotalBooksAcrossAllLibraries() {
        return totalBooksAcrossAllLibraries;
    }

    public String getLibraryInfo() {
        return "Library Name: " + libraryName + ", Book Count: " + bookCount;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", bookCount=" + bookCount +
                ", booksList=" + booksList +
                '}';
    }

    @Override
    public int hashCode() {
        return libraryName.hashCode() + bookCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Library that = (Library) obj;
        return bookCount == that.bookCount && libraryName.equals(that.libraryName);
    }
}
