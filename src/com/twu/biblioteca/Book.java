package com.twu.biblioteca;
// leave accessible for testing


public class Book {

    public String name;
    String title;
    String author;
    Integer yearPublished;
    Boolean available;


    public Book(String bookName, String authorName, int year, boolean status) {
        title = bookName;
        author = authorName;
        yearPublished = year;
        available = status;
    }

    public void checkout(Book book){

        available = false;

    }




}
