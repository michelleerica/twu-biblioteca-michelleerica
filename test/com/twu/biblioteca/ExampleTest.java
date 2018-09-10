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
        assertEquals(library.getWelcomeMessage(), "Welcome to Biblioteca");
    }
//
//    @Test
//    public printMessage(){
//        assertEquals(library.printMessage("hello"), "hello");
//    }

}
