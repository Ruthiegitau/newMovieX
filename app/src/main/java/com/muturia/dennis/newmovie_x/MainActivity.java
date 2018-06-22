package com.muturia.dennis.newmovie_x;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.muturia.dennis.newmovie_x.models.Movie;
import com.muturia.dennis.newmovie_x.services.Services;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();//Will be using this to log the data in the logcat
    ArrayList<Movie>theMovies = new ArrayList<>();//This is here for testing if I was getting the individual data
    @BindView(R.id.hello)TextView apiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getMovies();
    }

    //This method links to the Services class to get the API data
    public void getMovies(){
        final Services services = new Services();
        services.getMyMovies(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()){
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                          theMovies = services.processResults(response);//Testing purposes
                        }
                    });
                }
            }
        });
    }
}
