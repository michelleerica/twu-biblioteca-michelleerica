package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
public class UserTest {
    private User user = new User("123-1234", "password", "Michelle", "50 Carrington", "0409 564 123");


    @Test
    public void constructorTest(){

        assertEquals("123-1234", user.id);
    }

}