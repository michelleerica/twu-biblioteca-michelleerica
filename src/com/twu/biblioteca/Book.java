package com.twu.biblioteca;
// leave accessible for testing


public class Book {

    int id;
    String title;
    String author;
    Integer yearPublished;
    Boolean available;


    public Book(int num, String bookName, String authorName, int year, boolean status) {
        id = num;
        title = bookName;
        author = authorName;
        yearPublished = year;
        available = status;
    }

    public void changeStatus(Book book, String status){
        if(status == "borrow") {
            available = false;
        } else if(status == "return"){
            available = true;
        }


    }


}
