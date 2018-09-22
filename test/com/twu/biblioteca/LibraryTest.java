package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;



public class LibraryTest {
    private Library library;
    private User user;

    @Before
    public void setUp() {
        library = new BookSection();
        user = new User();
        user.setId("123-1234");
        user.setName("Michelle");
        user.setPassword("password");
        user.setAddress("50 Carrington");
        user.setPhoneNumber("0409 564 123");
    }

    @Test
    public void welcomeMessageTest() {
        assertThat("Welcome to Biblioteca", is(equalTo(library.getWelcomeMessage())));
    }

    @Test
    public void optionListTest() {
        String message = "Menu options: \n" +
                " VB: View All Books\n" +
                " BB: View available for checkout\n" +
                " R: Return\n" +
                " VM: View All Movies\n" +
                " BM: View available for checkout\n" +
                " U: See user details";

        assertEquals(message, library.getMenu());
    }

    @Test
    public void loginDisplayTest() {
        String message = "Please log in";
        assertEquals(message, library.loginDisplay());
    }

    @Test
    public void listAvailableResourcesTest(){
        library.getResourceList("book");
        assertThat(true, is(equalTo(library.listAvailableResources("book"))));
    }

    @Test
    public void menuInteractivityTest(){
        library.optionSelected = "Q";
        assertThat("Q", is(equalTo(library.menuInteractivity())));

    }

//    @Test
//    public void checkMatchTest() {
////        System.out.println(user.isLoggedIn());
////        library.checkMatch("123-1234", "password");
////        System.out.println(user.isLoggedIn());
//
////        assertTrue(library.checkMatch("123-1234", "password"));
//        assertFalse(library.checkMatch("123-123]", "password"));
//    }
//
//    @Test
//    public void getUserDetailsTest(){
//        String userDetails =
//                "User ID: 123-1234\n" +
//                "Name: Michelle\n" +
//                "Address: 50 Carrington\n" +
//                "Phone: 0409 564 123";
//
//        assertEquals(userDetails, library.getUserDetails());
//
//    }
}
