package com.muturia.dennis.newmovie_x.services;

import android.util.Log;

import com.muturia.dennis.newmovie_x.Constants;
import com.muturia.dennis.newmovie_x.models.Movie;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Services {
    /*
    *In this file we will be calling all the data from the api key
    * Ill start by building the url to call the API
     */
    public static void getMyMovies(okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder builder = HttpUrl.parse(Constants.urlApi).newBuilder();
        String url = builder.build().toString();

        Log.d("Url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    /*
    *Now I will start with fetching of individual data from the API
    * But first we will need the models file
    */
    public ArrayList<Movie> processResults(Response response){
        ArrayList<Movie> movies = new ArrayList<>();
        try {
         String jsonData = response.body().string();//The response gotten from the api in string form
         if (response.isSuccessful()){//Checking if the response is given
             JSONArray jsonArray = new JSONArray(jsonData);
             for (int i = 0; i <= jsonArray.length(); i++){//Looping through the objects in the API
                 JSONObject jsonObject = jsonArray.getJSONObject(i);
                 String movieName = jsonObject.getString("movie_title");
                 String day = jsonObject.getString("days");
                 String status = jsonObject.getString("status");
                 String price = jsonObject.getString("price");

                 //Storing the individual data in the the models of an Arraylist
                 Movie movie = new Movie(movieName, day, status, price);

                 movies.add(movie);
             }
         }
        }catch (Exception e){
            e.printStackTrace();
        }
        return movies;
    }
}
