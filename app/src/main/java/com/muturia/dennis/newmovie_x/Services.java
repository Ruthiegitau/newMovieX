package com.muturia.dennis.newmovie_x;

import android.util.Log;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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

}
