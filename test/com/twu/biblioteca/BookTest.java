package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book("Huckleberry Finn", "Mark Twain", 1884);
////
//    @Before
//    public void setUp() {
//        //        book = new Book("Huckleberry Finn");
////
//    }

    @Test
    public void constructorTest(){
//        Book b = new Book("Huckleberry Finn");
        assertEquals("Huckleberry Finn", book.title);

    }



}