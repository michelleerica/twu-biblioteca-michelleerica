package com.twu.biblioteca;
import java.util.ArrayList;


// leave accessible for testing

import java.util.Scanner;
import java.util.Objects;


public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";
    public static ArrayList<Book> books = new ArrayList<Book>();
    static String optionSelected;


    private static void setUpLibrary(){

        Book one = new Book(1,"Huckleberry Finn", "Mark Twain", 1884, true);
        Book two = new Book(2,"Tom Sawyer", "Mark Twain", 1884, true);
        Book three = new Book(3,"Little Women", "Louise May Alcott", 1868, false);
        books.add(one);
        books.add(two);
        books.add(three);
    }

    private static String menu = "Menu options: \n" +
            " L: View All Books\n" +
            " C: View available books for checkout";

    public static void main(String[] args) {
        setUpLibrary();
        printMessage(getWelcomeMessage());
//        printMessage(getMenu());
        run();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printList(ArrayList<Book> books) {

        for (Book book: books) {
            String info = book.id + " | " + book.title + " | " + book.author + " | " + book.yearPublished + " | " + book.available;
            printMessage(info);
        }
    }

    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static ArrayList<Book> getBookList(){
        return books;
    }

    public static String getMenu() {
        return menu;
    }

    public static void run() {
        Scanner userInput = new Scanner(System.in);
        printMessage(getMenu());

        printMessage("Select an option: ");

        optionSelected = userInput.next().substring(0,1);
        menuInteractivity();
    }

    public static void menuInteractivity(){

        if (Objects.equals (optionSelected, "Q")){
            printMessage("QUIT");
        } else if (Objects.equals (optionSelected, "L")) {
            printMessage("you selected L \nAll books at Biblioteca");
            listAllBooks();
            printMessage("To borrow a book, please type in 'C'");
            run();

        } else if (Objects.equals (optionSelected, "C")) {
            printMessage("you selected C \nBooks available");
            listAvailableBooks();
            chooseBook();
        } else {
            printMessage("Select a valid option");
//            run();
        }

        run();
    }

    public static void chooseBook(){
        Scanner bookSelector = new Scanner(System.in);

        printMessage("Which book would you like (provide # e.g. 1)?");

        String bookID = bookSelector.nextLine();
        printMessage("You are checking out book #" + bookID);

        checkout(bookID);

        printMessage("Thank you! Enjoy the book");
        run();


    }

    public static void listAllBooks(){
        printList(getBookList());
    }

    public static void listAvailableBooks(){
        System.out.println("LIST OF AVAILABLE BOOKS");


        for (Book book: books) {
            if (book.available ){

                String info = book.id + " | " + book.title + " | " + book.author + " | " + book.yearPublished;
                printMessage(info);
            }
        }
    }

    public static void checkout(String num){

        int id = Integer.parseInt(num);

        for (Book book: books) {
            if (book.id == id ){
                book.checkout(book);
            }
        }

//        book.checkout(book);
    }


}
