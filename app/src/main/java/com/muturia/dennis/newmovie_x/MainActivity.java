package com.muturia.dennis.newmovie_x;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();//Will be using this to log the data in the logcat
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
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            apiData.setText(jsonData);
                        }
                    });
                }
            }
        });
    }
}
