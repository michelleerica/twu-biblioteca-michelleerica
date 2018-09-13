package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExampleTest {
    private Library library;


    public static ArrayList<Book> books = new ArrayList<Book>();
    private Book one;

    @Before
    public void setUpLibrary(){
        one = new Book("Huckleberry Finn", "Mark Twain", 1884, true);
        Book two = new Book("Tom Sawyer", "Mark Twain", 1884, true);
        Book three = new Book("Little Women", "Louise May Alcott", 1868, false);
        books.add(one);
        books.add(two);
        books.add(three);
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void welcomeMessageTest(){
        assertEquals("Welcome to Biblioteca", library.getWelcomeMessage());
    }

    @Test
    public void optionListTest(){
        String message = "Menu options: \n" +
                " L: View All Books\n" +
                " C: View available books for checkout";

        assertEquals(message, library.getMenu());
    }


    @Test
    public void checkoutTest(){
        library.checkout(one);
        assertFalse(one.available);
    }


}
