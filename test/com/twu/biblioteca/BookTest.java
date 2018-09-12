package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book("Huckleberry Finn", "Mark Twain", 1884);


    @Test
    public void constructorTest(){
        assertEquals("Huckleberry Finn", book.title);

    }



}