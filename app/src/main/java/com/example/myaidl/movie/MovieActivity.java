package com.example.myaidl.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myaidl.R;
import com.example.myaidl.network.Api;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Api.getApiService().getTopMovies(0,10);
    }
}
