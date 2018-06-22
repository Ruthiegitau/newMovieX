package com.muturia.dennis.newmovie_x;

public class Movie {
    private String name;
    private String status;
    private String day;
    private String price;

    public Movie(String name, String status, String day, String price){
        this.name = name;
        this.status = status;
        this.day = day;
        this.price = price;
    }
    //Setting the getter for the data to be retrieved from the api

    public String getMovieName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDay() {
        return day;
    }

    public String getPrice() {
        return price;
    }
}
