package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
public class BookTest {
    private Book book = new Book(1,"Huckleberry Finn", 1884, true, "Mark Twain");
    private Book bookUnavailable = new Book(2,"Little Women", 1844, false, "Louise May Alcott" );


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