package com.twu.biblioteca;
import java.util.Arrays;


// leave accessible for testing

public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";
    private static Book books = new Book("Huckleberry Finn");


    public static void main(String[] args) {

        String message;
        message = getWelcomeMessage();
        printMessage(message);
        printMessage("List of books");
        getBookList();
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }


    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static String getBookList(){

        return books.title;
    }




}
