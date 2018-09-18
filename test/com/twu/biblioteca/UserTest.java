package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class UserTest {
    private User user;

    @Before
    public void createUser(){
        user = new User();
        user.setId("123-1234");
        user.setPassword("password");
        user.setName("Michelle");
        user.setAddress("50 Carrington");
        user.setPhoneNumber("0409 564 123");

    }
    @Test
    public void constructorTest(){

        assertEquals("123-1234", user.getId());
    }

}