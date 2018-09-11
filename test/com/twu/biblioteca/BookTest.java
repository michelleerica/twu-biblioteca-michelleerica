package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Test
    public void constructorTest(){
        Book b = new Book("Huckleberry Finn");
        assertEquals("Huckleberry Finn", b);
    }

}