package com.example.sqlite_demo.models;

/**
 * Created by dell on 01-07-2017.
 */

public class Movie {

    String movie;

    public String getMovie() {
        return movie;
    }

    public String getStudio() {
        return studio;
    }

    public int getYear() {
        return year;
    }

    public long getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    private String studio;
    private int year;
    private long id;
    private double rating;

    public Movie(String movie, String studio, int year, long id, double rating) {
        this.movie = movie;
        this.studio = studio;
        this.year = year;
        this.id = id;
        this.rating = rating;
    }
}
