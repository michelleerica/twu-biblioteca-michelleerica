package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private Library library;

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void welcomeMessageTest(){
        assertEquals("Welcome to Biblioteca", library.getWelcomeMessage());
    }

//    @Test
//    public void optionList(){
//        assertEquals("Menu options", library.getMenu());
//    }

    @Test
    public void optionListTest(){
        String message = "Menu options \n" +
                "List Books";
        assertEquals(message, library.getMenu());
    }

}
