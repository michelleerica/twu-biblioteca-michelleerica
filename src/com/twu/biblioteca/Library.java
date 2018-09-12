package com.twu.biblioteca;
import java.util.Arrays;


// leave accessible for testing

public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";
    private static Book[] books = new Book[]{
            new Book("Huckleberry Finn"),
            new Book("Little Women")
    };



    public static void main(String[] args) {

        String message;
        message = getWelcomeMessage();
        printMessage(message);
        printMessage("List of books");
        printList(getBookList());
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printList(Book[] books) {

        for (Book book: books) {
            printMessage(book.title);
        }

    }


    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static Book[] getBookList(){

        return books;
    }





}
