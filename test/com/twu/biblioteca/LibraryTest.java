package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;


public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new BookSection();
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

}
