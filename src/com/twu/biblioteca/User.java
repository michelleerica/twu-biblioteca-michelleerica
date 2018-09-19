package com.twu.biblioteca;

public class User {
    private String id;
    private String password;
    private Boolean loggedIn;
    private String name;
    private String address;
    private String phoneNumber;

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
        return id;
    }

    String getPassword(){
        return this.password;
    }

    String getName(){
        return this.name;
    }

    String getAddress(){
        return this.address;
    }

    String getPhoneNumber(){
        return this.phoneNumber;
    }

    Boolean setStatus(boolean status){
        this.loggedIn = status;
        System.out.print(this.loggedIn);
        return this.loggedIn;
    }

    Boolean isLoggedIn(){
        return this.loggedIn;
    }
}
