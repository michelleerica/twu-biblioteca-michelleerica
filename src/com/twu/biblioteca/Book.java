package com.twu.biblioteca;
// leave accessible for testing


public class Book {

    public String name;
    String title;
    String author;
    Integer yearPublished;


    public Book(String bookName, String authorName, int year) {
        title = bookName;
        author = authorName;
        yearPublished = year;
    }

}
