package com.twu.biblioteca;
//import java.util.Arrays;


// leave accessible for testing

import java.util.Scanner;
import java.util.Objects;


public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";
    private static Book[] books = new Book[]{
            new Book("Huckleberry Finn", "Mark Twain", 1884),
            new Book("Little Women", "Louise May Alcott", 1868)
    };
    private static String menu = "Menu options \n" +
            "List Books";

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


    public static String getMenu() {
        return menu;
    }

    public static void run() {
        Scanner userInput = new Scanner(System.in);

        printMessage("Select an option: Type 'L' for List Books");

        String optionSelected;

        optionSelected = userInput.next().substring(0, 1);

        if (Objects.equals (optionSelected, "L")){
            printMessage("you selected L \nBooks available");
            listBooks();
        } else {
            printMessage("try again");
            run();
        }
    }

    private static void listBooks(){
        printList(getBookList());

    }

}
