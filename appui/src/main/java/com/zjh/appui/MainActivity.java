package com.zjh.appui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zjh.appui.ui.main.SectionsPagerAdapter;
import com.zjh.appui.util.Myworker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private String TAG  = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this,CustomLifecycleActivity.class);
                startActivity(intent);
            }
        });



        getLifecycle().addObserver(new ActivityLifecycleObserver());
    }


    private void doOnceWork(){
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(Myworker.class).build();
        WorkManager.getInstance().enqueue(request);
    }

    private void repeatWork(){
        //可以给任务加一些运行的Constraints条件，比如说当设备空闲时或者正在充电或者连接WiFi时执行任务。
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();

        PeriodicWorkRequest build = new PeriodicWorkRequest.Builder(Myworker.class, 25, TimeUnit.MILLISECONDS)
                .addTag(TAG)
                .setConstraints(constraints)
                .build();

        WorkManager instance = WorkManager.getInstance();
        if (instance != null) {
            instance.enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.REPLACE, build);
        }
    }
}