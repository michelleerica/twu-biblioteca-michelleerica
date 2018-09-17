package com.twu.biblioteca;

public class User {
    String id;
    String password;
    Boolean loggedIn;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        loggedIn = false;
    }



}
