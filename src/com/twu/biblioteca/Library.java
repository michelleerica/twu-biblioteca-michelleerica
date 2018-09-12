package com.twu.biblioteca;
import java.util.Arrays;


// leave accessible for testing

import java.util.Scanner;
import java.util.Objects;


public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";
    private static Book[] books = new Book[]{
            new Book("Huckleberry Finn", "Mark Twain", 1884,  true),
            new Book("Tom Sawyer", "Mark Twain", 1884, true),
            new Book("Little Women", "Louise May Alcott", 1868, false)
    };

    private static String menu = "Menu options: \n" +
            " L: View All Books\n" +
            " C: View available books for checkout";

    public static void main(String[] args) {

        printMessage(getWelcomeMessage());
        printMessage(getMenu());
        run();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printList(Book[] books) {

        for (Book book: books) {
            String info = book.title + " | " + book.author + " | " + book.yearPublished + " | " + book.available;
            printMessage(info);
        }
    }

    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static Book[] getBookList(){
        return books;
    }

    public static String getMenu() {
        return menu;
    }

    public static void run() {
        Scanner userInput = new Scanner(System.in);

        printMessage("Select an option: ");

        String optionSelected;

        optionSelected = userInput.next().substring(0, 1);

        if (Objects.equals (optionSelected, "Q")){
            printMessage("QUIT");

        } else if (Objects.equals (optionSelected, "L")) {
            printMessage("you selected L \nAll books at Biblioteca");
            listAllBooks();
        } else if (Objects.equals (optionSelected, "C")) {
            printMessage("you selected C \nBooks available");
            listAvailableBooks();
        } else {
            printMessage("Select a valid option");
            run();
        }
    }

    public static void listAllBooks(){
        printList(getBookList());
    }

    public static void listAvailableBooks(){
        System.out.println("LIST OF AVAILABLE BOOKS");


        for (Book book: books) {
            if (book.available == true){

                String info = book.title + " | " + book.author + " | " + book.yearPublished;
                printMessage(info);
            }

        }

    }

    public static void checkout(Book book){

        book.checkout(book);
        System.out.println("CHECKOUT");

    }



}
