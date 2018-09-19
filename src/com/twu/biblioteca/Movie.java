package com.twu.biblioteca;

public class Movie extends Resource{

    String director;
    int movieRating;

    public Movie(int num, String name, int year, boolean status, String directorName, int stars) {
        super( num,  name,  year, status);

        this.director = directorName;
        this.movieRating = stars;


    }


}