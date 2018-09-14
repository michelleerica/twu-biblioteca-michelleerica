package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
public class UserTest {
    private User user = new User("123-1234", "password1");


    @Test
    public void constructorTest(){

        assertEquals("123-1234", user.id);
    }

}