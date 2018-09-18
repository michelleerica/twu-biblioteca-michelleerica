package com.twu.biblioteca;

public class User {
    String id;
    String password;
    Boolean loggedIn;
    String name;
    String address;
    String phoneNumber;

    public User() {

        loggedIn = false;

    }

    public void setId(String id){
        this.id = id;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    String getId(){
        return this.id;
    }



}
