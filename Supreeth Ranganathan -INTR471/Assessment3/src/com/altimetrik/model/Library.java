package com.altimetrik.model;

public class Library {
    private int bookID;
    private String bookName;
    private String genre;
    private int bookCost;
    private String available;

    @Override
    public String toString() {
        return "Library{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", bookCost=" + bookCost +
                ", available='" + available + '\'' +
                '}';
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBookCost() {
        return bookCost;
    }

    public void setBookCost(int bookCost) {
        this.bookCost = bookCost;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Library() {
    }

    public Library(int bookID, String bookName, String genre, int bookCost, String available) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.genre = genre;
        this.bookCost = bookCost;
        this.available = available;
    }
}
