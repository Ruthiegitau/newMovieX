package com.muturia.dennis.newmovie_x.models;

public class Movie {
    private String name;
    private String status;
    private String day;
    private String price;
    private String image;

    public Movie(String name, String status, String day, String price, String image){
        this.name = name;
        this.status = status;
        this.day = day;
        this.price = price;
        this.image = image;
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

    public String getImage() {
        return image;
    }
}
