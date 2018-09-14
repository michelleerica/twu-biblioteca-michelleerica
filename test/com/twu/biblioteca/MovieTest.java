package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie = new Movie(1,"Mean Girls", 2004, true, "Lorne Michaels", 9);


    @Test
    public void constructorTest(){

        assertEquals("Mean Girls", movie.title);
    }

}