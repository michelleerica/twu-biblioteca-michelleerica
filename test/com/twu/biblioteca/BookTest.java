package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book(1,"Huckleberry Finn", "Mark Twain", 1884, true);
    private Book bookUnavailable = new Book(2,"Little Women", "Louise May Alcott", 1844, false);


    @Test
    public void constructorTest(){
        assertEquals("Huckleberry Finn", book.title);

    }

    @Test
    public void checkOutTest(){
        book.changeStatus(book,"borrow");
        assertFalse(book.available);
    }

    @Test
    public void checkInTest(){
        bookUnavailable.changeStatus(book,"return");
        assertTrue(bookUnavailable.available);
    }


}