package com.twu.biblioteca;

public class Book extends Resource{

    String author;

    public Book(int num, String name, int year, boolean status, String authorName) {
        super( num,  name,  year, status);

        this.author = authorName;


    }
//
//    public void changeStatus(Book book, String status){
//        if(status == "borrow") {
//            available = false;
//        } else if(status == "return"){
//            available = true;
//        }
//
//
//    }


}
