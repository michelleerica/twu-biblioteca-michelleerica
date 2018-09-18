package com.twu.biblioteca;

public class User {
    String id;
    String password;
    Boolean loggedIn;
    String name;
    String address;
    String phoneNumber;

    public User(String id, String password, String name, String address, String phoneNumber) {
        this.id = id;
        this.password = password;
        loggedIn = false;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }



}
