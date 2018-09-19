package com.twu.biblioteca;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Objects;


public abstract class Library {

    static ArrayList<Resource> resources = new ArrayList<Resource>();
    static ArrayList<Resource> allBooks = new ArrayList<Resource>();
    static ArrayList<Resource> allMovies = new ArrayList<Resource>();
    static ArrayList<Resource> availableResources = new ArrayList<Resource>();
    static ArrayList<Resource> availableBooks = new ArrayList<Resource>();
    static ArrayList<Resource> availableMovies = new ArrayList<Resource>();


    private static User user = new User();

    private static String welcomeMessage = "Welcome to Biblioteca";

    private static String loginMessage = "Please log in";

    private static String menu = "Menu options: \n" +
            " VB: View All Books\n" +
            " BB: View available for checkout\n" +
            " R: Return\n" +
            " VM: View All Movies\n" +
            " BM: View available for checkout\n" +
            " U: See user details";

    static String optionSelected;

    public static void main(String[] args) {
        user.setId("123-1234");
        user.setName("Michelle");
        user.setPassword("password");
        user.setAddress("50 Carrington");
        user.setPhoneNumber("0409 564 123");

        printMessage(getWelcomeMessage());
        setUpLibrary();
        run();
    }


    public static void setUpLibrary(){

        Book one = new Book(1,"Huckleberry Finn",  1884, true, "Mark Twain");
        Book two = new Book(2,"Tom Sawyer",  1884, true, "Mark Twain");
        Book three = new Book(3,"Little Women", 1868, false,"Louise May Alcott");
        resources.add(one);
        resources.add(two);
        resources.add(three);

        Movie m1 = new Movie(1,"Black Swan",  2010, true, "Darren Aronofsky", 8);
        Movie m2 = new Movie(2,"To All The Boys I've Loved Before",  2018, true, "Susan Johnson", 8);
        resources.add(m1);
        resources.add(m2);
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

    public static ArrayList<Resource> getResourceList(String type){
        for (Resource r : resources) {
            if (r instanceof Book) {
                allBooks.add(r);
            } else if (r instanceof Movie) {
                allMovies.add(r);
            }
        }

        if(type == "allBooks"){
            return allBooks;
        }else{
            return allMovies;
        }
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

    public static void listAllResources(String type){
        printList(getResourceList(type));
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

        if (Objects.equals (optionSelected, "VB")) {
            printMessage("you selected VB \nAll books at Biblioteca");
            listAllResources("allBooks");
            chooseResourceToAction("checkout");
        } else if (Objects.equals (optionSelected, "BB")) {
            printMessage("you selected BB \nBooks available");
            listAvailableResources();
            loginInteraction("checkout");
            chooseResourceToAction("checkout");
        } else if (Objects.equals (optionSelected, "R")) {
            printMessage("you selected R \nReturn book");
            listNotAvailableResources();
            loginInteraction("checkin");
            chooseResourceToAction("checkin");
        } else if (Objects.equals (optionSelected, "VM")) {
            printMessage("you selected VM \nAll movies at Biblioteca");
            listAllResources("allMovies");
        } else if (Objects.equals (optionSelected, "BM")) {
            printMessage("you selected BM \nMovies available");
            listAvailableResources();
            loginInteraction("checkout");
            chooseResourceToAction("checkout");
        } else if (Objects.equals (optionSelected, "U")) {
            loginInteraction("see personal details");
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

        printMessage("You wish to checkout book #" + resourceID);

        if(action == "checkout") {
            printMessage("You wish to checkout book #" + resourceID);
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
        return loginMessage;
    }

    public static void loginInteraction(String action){

        Scanner loginInfo = new Scanner(System.in);
        printMessage("You will need to log in to " + action + "\nPlease log in");
        printMessage("Id: ");

        String userId = loginInfo.next();
        printMessage("Password: ");
        String password = loginInfo.next();

        boolean success = checkMatch(userId, password);
        System.out.println(success);
        if (success){
            printMessage("yay");
            if(action == "see personal details"){
                printMessage(getUserDetails());
                run();
            }else {
                chooseResourceToAction(action);
            }
        }else{
            printMessage("Please try again");
            loginInteraction(action);
        }
    }

    public static boolean checkMatch(String inputId, String inputPassword) {
        System.out.println("inputId");

        System.out.println(inputId);
        System.out.println(user.getId());
        System.out.println("passwordINPUT");

        System.out.println(inputPassword);
        System.out.println(user.getPassword());

        if (Objects.equals(inputId, user.getId()) && Objects.equals(inputPassword, user.getPassword())) {
            user.setStatus(true);
        } else {
            user.setStatus(false);
        }
        return user.isLoggedIn();

    }


    public static String getUserDetails(){

        String userDetails =
                "User ID: " + user.getId() +
                "\nName: " + user.getName() +
                "\nAddress: " + user.getAddress() +
                "\nPhone: " + user.getPhoneNumber();

        return userDetails;
    }




}