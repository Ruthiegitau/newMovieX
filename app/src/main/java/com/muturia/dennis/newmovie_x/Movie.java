package com.muturia.dennis.newmovie_x;

public class Movie {
    private String name;
    private String status;
    private String day;

    public Movie(String name, String status, String day){
        this.name = name;
        this.status = status;
        this.day = day;
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
}
