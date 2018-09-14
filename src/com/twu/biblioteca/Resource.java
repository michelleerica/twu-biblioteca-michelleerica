package com.twu.biblioteca;

public class Resource {

    int id;
    String title;
    Integer yearReleased;
    Boolean available;

    public Resource(int num, String name, int year, boolean status) {
        id = num;
        title = name;
        yearReleased = year;
        available = status;
    }


    public void changeStatus(Resource resource, String status){
        if(status == "borrow") {
            available = false;
        } else if(status == "return"){
            available = true;
        }


    }
}
