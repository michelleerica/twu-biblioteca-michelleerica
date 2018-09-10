//package com.twu.biblioteca;

// leave accessible for testing

public class Library {

    private static String welcomeMessage = "Welcome to Biblioteca";

    public static void main(String[] args) {

        String message = getWelcomeMessage();
        printMessage(message);

    }

    private static void printMessage(String message) {
                System.out.println(message);
    }


    public static String getWelcomeMessage() {
        return welcomeMessage;
    }




}
