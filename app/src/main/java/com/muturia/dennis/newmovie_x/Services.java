package com.muturia.dennis.newmovie_x;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Services {
    /*
    *In this file we will be calling all the data from the api key
    * Ill start by building the url to call the API
     */
    public static void getMyMovies(Callback callback){
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder builder = HttpUrl.parse(Constants.urlApi).newBuilder();
        String url = builder.build().toString();

        Log.d("Url", url);

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
