package com.twu.biblioteca;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Objects;


public class Library {

    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<Book> availableBooks = new ArrayList<Book>();

    private static String welcomeMessage = "Welcome to Biblioteca";

    private static String menu = "Menu options: \n" +
            " L: View All Books\n" +
            " C: View available books for checkout\n" +
            " R: Return a book";

    static String optionSelected;

    public static void main(String[] args) {
        setUpLibrary();
        printMessage(getWelcomeMessage());
        run();
    }

    private static void setUpLibrary(){

        Book one = new Book(1,"Huckleberry Finn",  1884, true, "Mark Twain");
        Book two = new Book(2,"Tom Sawyer",  1884, true, "Mark Twain");
        Book three = new Book(3,"Little Women", 1868, false,"Louise May Alcott");
        books.add(one);
        books.add(two);
        books.add(three);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printList(ArrayList<Book> books) {

        for (Book book: books) {
            String status;
            if(book.available){
                status = "Available";
            }else{
                status = "Not available";
            }

            String info = book.id + " | " + book.title + " | " + book.author + " | " + book.yearReleased + " | " + status;
            printMessage(info);
        }
    }

    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static ArrayList<Book> getBookList(){
        return books;
    }

    public static ArrayList<Book> getAvailableBookList(){
        for (Book book: books) {
            if (book.available ){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public static String getMenu() {
        return menu;
    }

    public static void listAllBooks(){
        printList(getBookList());
    }

    public static void listAvailableBooks(){
        System.out.println("LIST OF AVAILABLE BOOKS");
        ArrayList<Book> updatedBookList = getAvailableBookList();

        for (Book book: updatedBookList) {
            String info = book.id + " | " + book.title + " | " + book.author + " | " + book.yearReleased;
            printMessage(info);
        }
    }

    public static void listNotAvailableBooks(){

        for (Book book: books) {
            if (!book.available) {
                String info = book.id + " | " + book.title + " | " + book.author + " | " + book.yearReleased;
                printMessage(info);
            }
        }
    }


    public static void run() {
        Scanner userInput = new Scanner(System.in);
        printMessage(getMenu());

        printMessage("Select an option: ");

        optionSelected = userInput.nextLine();
        if(optionSelected == "Q"){
            printMessage("QUIT");
        } else {
            menuInteractivity();
        }
    }

    public static void menuInteractivity(){

        if (Objects.equals (optionSelected, "L")) {
            printMessage("you selected L \nAll books at Biblioteca");
            listAllBooks();
            chooseBookToBorrow();
        } else if (Objects.equals (optionSelected, "C")) {
            printMessage("you selected C \nBooks available");
            listAvailableBooks();
            chooseBookToBorrow();
        } else if (Objects.equals (optionSelected, "R")) {
            printMessage("you selected R \nReturn book");
            listNotAvailableBooks();
            chooseBookToReturn();
        } else {
            printMessage("Select a valid option");
        }
        run();
    }

    public static void chooseBookToBorrow(){
        Scanner bookSelector = new Scanner(System.in);

        printMessage("Which book would you like (provide # e.g. 1)?");

        String bookID = bookSelector.nextLine();
        printMessage("You wish to check out book #" + bookID);

        checkout(bookID);

        printMessage("Thank you! Enjoy the book");
        run();

    }

    public static void chooseBookToReturn(){
        Scanner bookSelector = new Scanner(System.in);

        printMessage("Which book would you like to return(provide # e.g. 1)?");

        String bookID = bookSelector.nextLine();
        printMessage("You wish to return book #" + bookID);

        checkIn(bookID);

        printMessage("Thank you for returning the book");
        run();

    }


    public static void checkout(String num){
        int id = 0;
        if(Integer.parseInt(num) > 0) {
            id = Integer.parseInt(num);
        }
        printMessage("You are getting "+ id);

        boolean found = false;

        for (Book book: books) {

            if (book.id == id ){
                    if (book.available) {
                        found = true;
                        book.changeStatus(book, "borrow");
                    } else {
                        printMessage("The book is not available, choose another book");
                        chooseBookToBorrow();
                    }
            }
        }
        if(!found){
            printMessage("Select another option");
        }

    }

    public static void checkIn(String num){
        int id = 0;
        if(Integer.parseInt(num) > 0) {
            id = Integer.parseInt(num);
        }
        printMessage("You are returning "+ id);

        for (Book book: books) {

            if (book.id == id ){
                if (!book.available) {
                    book.changeStatus(book, "return");

                } else{
                    printMessage("This is not a valid book to return, please check your book ID");
                    chooseBookToReturn();
                }
            } else {
                printMessage("Select another option");
            }
        }

    }

}
