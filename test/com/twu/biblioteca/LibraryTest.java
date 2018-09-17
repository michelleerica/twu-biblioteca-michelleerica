package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;


public class LibraryTest {
    private Library library;
    private User user;
    @Before
    public void setUp() {
        library = new BookSection();
        user = new User("123-1234", "password");
    }

    @Test
    public void welcomeMessageTest(){
        assertEquals("Welcome to Biblioteca", library.getWelcomeMessage());
    }

    @Test
    public void optionListTest(){
        String message = "Menu options: \n" +
                " L: View All \n" +
                " C: View available for checkout\n" +
                " R: Return";

        assertEquals(message, library.getMenu());
    }

    @Test
    public void loginDisplayTest(){
        String message = "Please log in";
        assertEquals(message, library.loginDisplay());
    }

    @Test
    public void loginInteractionTest(){
        String username = "123-1234";
        String password = "password";
        assertEquals(username, user.id);
        assertEquals(password, user.password);

    }
    @Test
    public void checkMatchTest(){
        assertTrue(library.checkMatch("123-1234", "password"));
        assertFalse(library.checkMatch("123-123]", "password"));
    }

    @Test
    public void checkInput(){
        ass
    }

}
