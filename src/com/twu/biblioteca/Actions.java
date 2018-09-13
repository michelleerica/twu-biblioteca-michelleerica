//package com.twu.biblioteca;
//
//import java.util.Objects;
//import java.util.Scanner;
//
//public class Actions extends Library{
//
//    Library library;
//
//    String optionSelected;
//    public static void run() {
//        Scanner userInput = new Scanner(System.in);
//        library.printMessage(library.getMenu());
//
//        library.printMessage("Select an option: ");
//
//        optionSelected = userInput.next().substring(0, 1);
//        menuInteractivity();
//    }
//
//    public void menuInteractivity() {
//
//        if (Objects.equals(optionSelected, "Q")) {
//            library.printMessage("QUIT");
//        } else if (Objects.equals(optionSelected, "L")) {
//            library.printMessage("you selected L \nAll books at Biblioteca");
//            library.listAllBooks();
//            chooseBookToBorrow();
//        } else if (Objects.equals(optionSelected, "C")) {
//            library.printMessage("you selected C \nBooks available");
//            library.listAvailableBooks();
//            chooseBookToBorrow();
//        } else if (Objects.equals(optionSelected, "R")) {
//            library.printMessage("you selected C \nReturn book");
//            library.listNotAvailableBooks();
//            chooseBookToReturn();
//        } else {
//            library.printMessage("Select a valid option");
//        }
//        run();
//    }
//
//    public void chooseBookToBorrow() {
//        Scanner bookSelector = new Scanner(System.in);
//
//        library.printMessage("Which book would you like (provide # e.g. 1)?");
//
//        String bookID = bookSelector.nextLine();
//        library.printMessage("You wish to check out book #" + bookID);
//
//        checkout(bookID);
//
//        library.printMessage("Thank you! Enjoy the book");
//        run();
//
//    }
//
//    public void chooseBookToReturn() {
//        Scanner bookSelector = new Scanner(System.in);
//
//        library.printMessage("Which book would you like to return(provide # e.g. 1)?");
//
//        String bookID = bookSelector.nextLine();
//        library.printMessage("You wish to return book #" + bookID);
//
//        checkIn(bookID);
//
//        library.printMessage("Thank you for returning the book");
//        run();
//
//    }
//
//
//    public void checkout(String num){
//        int id = 0;
//        if(Integer.parseInt(num) > 0) {
//            id = Integer.parseInt(num);
//        }
//        library.printMessage("I'm getting "+ id);
//
//
//        for (Book book: books) {
//
//            if (book.id == id ){
//                if (book.available) {
//                    book.changeStatus(book, "borrow");
//
//                } else {
//                    library.printMessage("The book is not available, choose book another book");
//                    chooseBookToBorrow();
//                }
//
//            } else library.printMessage("Select another option");
//        }
//
//    }
//
//    public void checkIn(String num){
//        int id = 0;
//        if(Integer.parseInt(num) > 0) {
//            id = Integer.parseInt(num);
//        }
//        library.printMessage("I'm returning "+ id);
//
//        for (Book book: books) {
//
//            if (book.id == id ){
//                if (!book.available) {
//                    book.changeStatus(book, "return");
//
//                } else{
//                    library.printMessage("This is not a valid book to return, please check your book ID");
//                    chooseBookToReturn();
//                }
//
//            } else {
//                library.printMessage("Select another option");
//            }
//        }
//
//    }
//
//}