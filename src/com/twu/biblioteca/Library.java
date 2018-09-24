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

    public static String optionSelected = "";
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
        Movie m2 = new Movie(2,"To All The Boys I've Loved Before",  2018, false, "Susan Johnson", 8);
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
        String ALL_BOOKS = "allBooks";

        if(type.equals(ALL_BOOKS)){
            return allBooks;
        }else{
            return allMovies;
        }
    }

    public static ArrayList<Resource> getAvailableResourceList(String type) {

        if (Objects.equals(type, "book")) {
            for (Resource book : allBooks) {
                if (book.available) {
                    availableBooks.add(book);
                }
            }
            return availableBooks;
        } else {
            for (Resource movie : allMovies) {
                if (movie.available) {
                    availableMovies.add(movie);
                }
            } return availableMovies;
        }
    }

    public static String getMenu() {
        return menu;
    }

    public static void listAllResources(String type){
        printList(getResourceList(type));
    }

    public static boolean listAvailableResources(String type){
        System.out.println("List of available " + type + "s");
        ArrayList<Resource> updatedResourceList = getAvailableResourceList(type);

        printList(updatedResourceList);

        return true;
    }


    public static void listNotAvailableResources(){

        for (Resource resource: resources) {
            if (!resource.available) {
                String info = resource.id + " | " + resource.title + " | " + resource.yearReleased;
                printMessage(info);
            }
        }
    }

    public static boolean run() {
        Scanner userInput = new Scanner(System.in);
        printMessage(getMenu());

        printMessage("Select an option: ");

        optionSelected = userInput.nextLine();

        menuInteractivity();
        return true;
    }

    public static void checkOutSequence(String action, String type){
        getResourceList(type);
        printMessage("you selected " + action + "\n " + type + " available");
        System.out.print(type);
        listAvailableResources(type);
        loginInteraction("checkout");
        selectResource("checkout", type);
    }

    public static String menuInteractivity() {
        if(Objects.equals (optionSelected, "Q")){
            printMessage("QUIT");
            System.exit(0);
        } else if (Objects.equals (optionSelected, "VB")) {
            printMessage("you selected VB \nAll books at Biblioteca");
            listAllResources("allBooks");
            selectResource("checkout", "book");
        } else if (Objects.equals (optionSelected, "BB")) {
            checkOutSequence("BB", "book");
        } else if (Objects.equals (optionSelected, "R")) {
            printMessage("you selected R \nReturn book");
            listNotAvailableResources();
            loginInteraction("checkin");
            selectResource("checkin", "book");
        } else if (Objects.equals (optionSelected, "VM")) {
            printMessage("you selected VM \nAll movies at Biblioteca");
            listAllResources("allMovies");
            selectResource("checkout", "movie");
        } else if (Objects.equals (optionSelected, "BM")) {
            checkOutSequence("BM", "movie");
        } else if (Objects.equals (optionSelected, "U")) {
            loginInteraction("see personal details");
        } else {
            printMessage("Select a valid option");
        }
        run();
        return optionSelected;
    }

    public static void selectResource(String action, String type){
        Scanner resourceSelector = new Scanner(System.in);

        printMessage("Which " + type + " would you like to " + action + " (provide # e.g. 1)?");

        String resourceID = resourceSelector.nextLine();

        int id = 0;
        if(Integer.parseInt(resourceID) > 0) {
            id = Integer.parseInt(resourceID);
        }else{
            menuInteractivity();
        }

        actionResource(action, type, id);
        run();


    }

    public static boolean actionResource(String action, String type, int resourceID){


        if(action == "checkout") {
            printMessage("You wish to " + action + " " + type + "#" + resourceID);
            checkout(resourceID, type);
            printMessage("Thank you! Enjoy the " + type);
            return true;

        } else if(action == "check in"){
            printMessage("You wish to " + action + " " + type + "#" + resourceID);
            checkout(resourceID, type);
            printMessage("Thank you for returning the " + type);
            return true;
        } else {
            return false;
        }

    }

    public static void checkout(int id, String type){

        printMessage("You are getting "+ id);

        boolean found = false;

        for (Resource resource: resources) { //todo limit loop to specific resource type (book/movie)

            if (resource.id == id ){
                    if (resource.available) {
                        found = true;
                        resource.changeStatus(resource, "borrow");
                    } else {
                        printMessage("The item is not available, choose again");
                        selectResource("checkout", type);
                    }
            }
        }
        if(!found){
            printMessage("Select another option");

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
        if (success){
            printMessage("Login successful");
            if(action == "see personal details"){
                printMessage(getUserDetails());
                run();
            }else {
                selectResource(action, "book");
            }
        }else{
            printMessage("Please try again");
            loginInteraction(action);
        }
    }

    public static boolean checkMatch(String inputId, String inputPassword) {
        System.out.print(user.getId());
        System.out.print(user.getPassword());

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