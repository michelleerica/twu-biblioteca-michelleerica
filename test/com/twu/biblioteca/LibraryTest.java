package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;


public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void welcomeMessageTest(){
        assertEquals("Welcome to Biblioteca", library.getWelcomeMessage());
    }

    @Test
    public void optionListTest(){
        String message = "Menu options: \n" +
                " L: View All Books\n" +
                " C: View available books for checkout\n" +
                " R: Return a book";

        assertEquals(message, library.getMenu());
    }

}
