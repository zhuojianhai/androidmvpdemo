package com.zjh.appui.databinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.zjh.appui.R;

public class ViewModeleDemoActivity extends AppCompatActivity {

    LiveDataTimerViewModel liveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_modele_demo);

//        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
//        liveDataTimerViewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(LiveDataTimerViewModel.class);
        liveDataTimerViewModel = new  ViewModelProvider(this).get(LiveDataTimerViewModel.class);
        subscribe();
    }
    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                 String newText = ViewModeleDemoActivity.this.getResources().getString(
                        R.string.seconds);
                ((TextView) findViewById(R.id.timer_textview)).setText(newText + aLong);
                Log.d("ViewModeleDemoActivity", "Updating timer");
            }
        };
        //
        liveDataTimerViewModel.getmElapsedTime().observe(this, elapsedTimeObserver);
    }
}
