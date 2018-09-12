package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book("Huckleberry Finn", "Mark Twain", 1884, true);
    private Book bookUnavailable = new Book("Little Women", "Louise May Alcott", 1844, false);


    @Test
    public void constructorTest(){
        assertEquals("Huckleberry Finn", book.title);

    }

    @Test
    public void checkOutTest(){
        assertFalse(bookUnavailable.available);
    }


}