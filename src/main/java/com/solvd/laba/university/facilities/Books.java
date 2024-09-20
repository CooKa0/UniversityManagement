package com.solvd.laba.university.facilities;

import com.solvd.laba.university.enums.BookGenre;

public class Books {
    private String title;
    private String author;
    private int yearPublished;
    private boolean isAvailable;
    private BookGenre genre;

    public Books(String title, String author, int yearPublished, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isAvailable = true;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public BookGenre getGenre() {
        return genre;
    }

    public String getBookDetails() {
        return "Title: " + title + ", Author: " + author + ", Year Published: " + yearPublished + ", Available: " + isAvailable + ", Genre: " + genre.getGenreDescription();
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", isAvailable=" + isAvailable +
                ", genre=" + genre.getGenreDescription() +
                '}';
    }
}
