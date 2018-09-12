package com.twu.biblioteca;
import java.util.Arrays;


// leave accessible for testing

public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";
    private static Book[] books = new Book[]{
            new Book("Huckleberry Finn", "Mark Twain", 1884),
            new Book("Little Women", "Louise May Alcott", 1868)
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
            String info = book.title + " | " + book.author + " | " + book.yearPublished;
            printMessage(info);
        }

    }


    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static Book[] getBookList(){

        return books;
    }





}
