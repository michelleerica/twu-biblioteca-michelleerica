package com.twu.biblioteca;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Objects;


public abstract class Library {

    static ArrayList<Resource> resources = new ArrayList<Resource>();
    static ArrayList<Resource> availableResources = new ArrayList<Resource>();

    static User user = new User("123-1234", "password");

    private static String welcomeMessage = "Welcome to Biblioteca";

    private static String loginMessage = "Please log in";

    private static String menu = "Menu options: \n" +
            " L: View All \n" +
            " C: View available for checkout\n" +
            " R: Return";

    static String optionSelected;
    private String[] args;

    public static void main(String[] args) {
        printMessage(getWelcomeMessage());
        setUpLibrary();
        loginInteraction("check in");
        run();
    }


    public static void setUpLibrary(){

        Book one = new Book(1,"Huckleberry Finn",  1884, true, "Mark Twain");
        Book two = new Book(2,"Tom Sawyer",  1884, true, "Mark Twain");
        Book three = new Book(3,"Little Women", 1868, false,"Louise May Alcott");
        resources.add(one);
        resources.add(two);
        resources.add(three);
    }

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
            chooseResourceToAction("checkout");
        } else if (Objects.equals (optionSelected, "C")) {
            printMessage("you selected C \nBooks available");
            listAvailableResources();
            chooseResourceToAction("checkout");
        } else if (Objects.equals (optionSelected, "R")) {
            printMessage("you selected R \nReturn book");
            listNotAvailableResources();
            chooseResourceToAction("checkin");
        } else {
            printMessage("Select a valid option");
        }
        run();
    }

    public static void chooseResourceToAction(String action){
        Scanner resourceSelector = new Scanner(System.in);

        printMessage("Which book would you like to " + action + " (provide # e.g. 1)?");

        String resourceID = resourceSelector.nextLine();

        int id = 0;
        if(Integer.parseInt(resourceID) > 0) {
            id = Integer.parseInt(resourceID);
        }else{
            menuInteractivity();
        }

        printMessage("You wish to check out book #" + resourceID);

        if(action == "checkout") {
            printMessage("You wish to check out book #" + resourceID);
            checkout(id);
            printMessage("Thank you! Enjoy the book");

        } else if(action == "check in"){
            printMessage("You wish to return book #" + resourceID);
            checkIn(id);
            printMessage("Thank you for returning the book");
        }
        run();

    }

    public static void checkout(int id){

        printMessage("You are getting "+ id);

        boolean found = false;

        for (Resource resource: resources) {

            if (resource.id == id ){
                    if (resource.available) {
                        found = true;
                        resource.changeStatus(resource, "borrow");
                    } else {
                        printMessage("The book is not available, choose another book");
                        chooseResourceToAction("checkout");
                    }
            }
        }
        if(!found){
            printMessage("Select another option");
        }

    }

    public static void checkIn(int id){

        printMessage("You are returning "+ id);

        for (Resource resource: resources) {

            if (resource.id == id ){
                if (!resource.available) {
                    resource.changeStatus(resource, "return");

                } else{
                    printMessage("This is not a valid book to return, please check your book ID");
                    chooseResourceToAction("check in");
                }
            } else {
                printMessage("Select another option");
            }
        }

    }


    public static String loginDisplay() {
        loginInteraction("check in");
        return loginMessage;
    }

    private static void loginInteraction(String action){
        Scanner resourceSelector = new Scanner(System.in);

        printMessage("Id: ");

        String userId = resourceSelector.nextLine();

        printMessage("Password: ");
        String password = resourceSelector.nextLine();

        printMessage(userId);
        printMessage(user.id);
        printMessage(password);
        printMessage(user.password);


        boolean success = checkMatch(userId, password);
        System.out.println(success);
        if (success){
            printMessage("yay");
            chooseResourceToAction(action);
        }else{
            printMessage("Please try again");
            loginInteraction(action);
        }


    }

    public static boolean checkMatch(String inputId, String inputPassword){
        if (user.id == inputId && user.password == inputPassword) {
            System.out.println("LOGGED IN");
            user.loggedIn = true;
        }else{
            System.out.println("try again");
            user.loggedIn = false;
        }
        return user.loggedIn;
    }

}
