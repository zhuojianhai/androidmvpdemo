package com.example.myaidl;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.LauncherActivity;
import android.content.Intent;
import android.content.res.Configuration;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import com.example.myaidl.activities.CoordinatLayout1Activity;
import com.example.myaidl.activities.CoordinatLayout2Activity;
import com.example.myaidl.activities.CoordinatLayout3Activity;
import com.example.myaidl.activities.CoordinatLayout4Activity;
import com.example.myaidl.activities.CoordinatLayout5Activity;
import com.example.myaidl.activities.CoordinatLayoutDemoActivity;
import com.example.myaidl.activities.CustomerLayoutActivity;
import com.example.myaidl.activities.CustomerViewActivity;
import com.example.myaidl.activities.ScableImageViewActivity;
import com.example.myaidl.activities.TouchViewActivity;
import com.example.myaidl.bean.Book;
import com.example.myaidl.hookactivity.HookHelper;
import com.example.myaidl.login.LoginActivity;
import com.example.myaidl.ui.main.PlaceholderFragment;
import com.example.myaidl.ui.main.PlaceholderFragment2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MainActivity";
    EditText num_et2;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        initDataAndView(fab);

        RecyclerView recyclerView = new RecyclerView(this);

        Log.e(TAG, "onCreate: >>>>>>" );
        if (savedInstanceState!=null){
            String name = (String) savedInstanceState.get("name");
            Log.e(TAG, "onCreate: savedInstanceState ----" +name);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(PlaceholderFragment.newInstance(1),"placeholderFragment");
        transaction.commit();


        System.out.println("》》》》》》》》》》》》》》》》》》》》了十几个两三加固");
    }

    @Override
   protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: >>>>>" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: >>>>>>>" );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: >>>>>>>>>>>>>>" );
        outState.putCharSequence("name","zhuojianahi");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume:>>>>>> " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: >>>>>>>>>>>>>" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: >>>>>>" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: >>>>>>>>>>>>" );
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        StringBuilder sb = new StringBuilder();
        sb.append(newConfig.orientation);
        sb.append("\n");
        Log.e(TAG, "onConfigurationChanged: "+sb.toString() );
    }

    private void initDataAndView(FloatingActionButton fab) {
        num_et2 = findViewById(R.id.et);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, CoordinatLayoutDemoActivity.class);
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.bt1);
        button2 = findViewById(R.id.bt2);
        button3 = findViewById(R.id.bt3);
        button4 = findViewById(R.id.bt4);
        button5 = findViewById(R.id.bt5);
        button6 = findViewById(R.id.bt6);
        button7 = findViewById(R.id.bt7);
        button8 = findViewById(R.id.bt8);
        button9 = findViewById(R.id.bt9);
        button10 = findViewById(R.id.bt10);
        button11 = findViewById(R.id.bt11);
        button12 = findViewById(R.id.bt12);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);

        final String pattern = "[^\\d+\\.?\\d{0,2}]";
        num_et2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                if (Pattern.matches(pattern, temp)) {
                    int posDot = temp.indexOf(".");
                    if (posDot <= 0) return;
                    if (temp.length() - posDot - 1 > 2) {
                        edt.delete(posDot + 3, posDot + 4);
                    }
                }

            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == button1) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout1Activity.class);
            startActivity(intent);
        } else if (v == button2) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout2Activity.class);
            startActivity(intent);
        } else if (v == button3) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout3Activity.class);
            startActivity(intent);
        } else if (v == button4) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout4Activity.class);
            startActivity(intent);
        } else if (v == button5) {
            Intent intent = new Intent(MainActivity.this, CoordinatLayout5Activity.class);
            startActivity(intent);

        } else if (v == button6) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }else if (v == button7) {
            Intent intent = new Intent(MainActivity.this, CustomerViewActivity.class);
            startActivity(intent);

        }else if (v == button8) {
            Intent intent = new Intent(MainActivity.this, CustomerLayoutActivity.class);
            startActivity(intent);

        }else if (v == button9) {
            Intent intent = new Intent(MainActivity.this, TouchViewActivity.class);
            startActivity(intent);

        }else if (v == button10) {
            Intent intent = new Intent(MainActivity.this, ScableImageViewActivity.class);
            startActivity(intent);

        }else if (v == button11) {
//            Intent intent = new Intent(MainActivity.this, ScableImageViewActivity.class);
//            startActivity(intent);

            ARouter.getInstance().build("/com/zjh/module/home/ui/login").navigation();

            FragmentManager f = getSupportFragmentManager();
            FragmentTransaction ft = f.beginTransaction();
           Fragment fragment =  f.findFragmentByTag("placeholderFragment");
           ft.setMaxLifecycle(fragment, Lifecycle.State.DESTROYED);


           ViewPager viewPager = new ViewPager(this);
           viewPager.setAdapter(new MyPagerAdapter());


            SurfaceView surfaceView = new SurfaceView(this);


        }else if (v==button12){
            try {
                HookHelper.replaceInstrumentation(this);
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    class  MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }




}