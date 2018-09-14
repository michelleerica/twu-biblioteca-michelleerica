package com.twu.biblioteca;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Objects;


public abstract class Library {

    static ArrayList<Resource> resources = new ArrayList<Resource>();
    static ArrayList<Resource> availableResources = new ArrayList<Resource>();

    private static String welcomeMessage = "Welcome to Biblioteca";

    private static String menu = "Menu options: \n" +
            " L: View All \n" +
            " C: View available for checkout\n" +
            " R: Return";

    static String optionSelected;
    private String[] args;

    public static void main(String[] args) {
        printMessage(getWelcomeMessage());
        run();
    }

    public abstract void setUpLibrary();

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printList(ArrayList<Resource> resources) {

        for (Resource resource: resources) {
            String status;
            if(resource.available){
                status = "Available";
            }else{
                status = "Not available";
            }

            String info = resource.id + " | " + resource.title + " | " + resource.yearReleased + " | " + status;
            printMessage(info);
        }
    }

    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static ArrayList<Resource> getResourceList(){
        return resources;
    }

    public static ArrayList<Resource> getAvailableResourceList(){
        for (Resource resource: resources) {
            if (resource.available ){
                availableResources.add(resource);
            }
        }
        return availableResources;
    }

    public static String getMenu() {
        return menu;
    }

    public static void listAllResources(){
        printList(getResourceList());
    }

    public static void listAvailableResources(){
        System.out.println("LIST OF AVAILABLE BOOKS");
        ArrayList<Resource> updatedResourceList = getAvailableResourceList();

        for (Resource resource: updatedResourceList) {
            String info = resource.id + " | " + resource.title + " | " + resource.yearReleased;
            printMessage(info);
        }
    }

    public static void listNotAvailableResources(){

        for (Resource resource: resources) {
            if (!resource.available) {
                String info = resource.id + " | " + resource.title + " | " + resource.yearReleased;
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
            listAllResources();
            chooseResourceToBorrow();
        } else if (Objects.equals (optionSelected, "C")) {
            printMessage("you selected C \nBooks available");
            listAvailableResources();
            chooseResourceToBorrow();
        } else if (Objects.equals (optionSelected, "R")) {
            printMessage("you selected R \nReturn book");
            listNotAvailableResources();
            chooseResourceToReturn();
        } else {
            printMessage("Select a valid option");
        }
        run();
    }

    public static void chooseResourceToBorrow(){
        Scanner resourceSelector = new Scanner(System.in);

        printMessage("Which book would you like (provide # e.g. 1)?");

        String resourceID = resourceSelector.nextLine();
        printMessage("You wish to check out book #" + resourceID);

        checkout(resourceID);

        printMessage("Thank you! Enjoy the book");
        run();

    }

    public static void chooseResourceToReturn(){
        Scanner resourceSelector = new Scanner(System.in);

        printMessage("Which book would you like to return(provide # e.g. 1)?");

        String resourceID = resourceSelector.nextLine();
        printMessage("You wish to return book #" + resourceID);

        checkIn(resourceID);

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

        for (Resource resource: resources) {

            if (resource.id == id ){
                    if (resource.available) {
                        found = true;
                        resource.changeStatus(resource, "borrow");
                    } else {
                        printMessage("The book is not available, choose another book");
                        chooseResourceToBorrow();
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

        for (Resource resource: resources) {

            if (resource.id == id ){
                if (!resource.available) {
                    resource.changeStatus(resource, "return");

                } else{
                    printMessage("This is not a valid book to return, please check your book ID");
                    chooseResourceToReturn();
                }
            } else {
                printMessage("Select another option");
            }
        }

    }

}
