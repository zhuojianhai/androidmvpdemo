package com.example.myaidl;

import android.content.Intent;
import android.os.Bundle;

import com.example.myaidl.activities.CoordinatLayout1Activity;
import com.example.myaidl.activities.CoordinatLayout2Activity;
import com.example.myaidl.activities.CoordinatLayout3Activity;
import com.example.myaidl.activities.CoordinatLayout4Activity;
import com.example.myaidl.activities.CoordinatLayout5Activity;
import com.example.myaidl.activities.CoordinatLayoutDemoActivity;
import com.example.myaidl.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myaidl.ui.main.SectionsPagerAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num_et2;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        initDataAndView(fab);

    }

    private void initDataAndView(FloatingActionButton fab) {
        num_et2  = findViewById(R.id.et);

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


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        final String pattern = "[^\\d+\\.?\\d{0,2}]";
        num_et2.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable edt)
            {
                String temp = edt.toString();
                if(Pattern.matches(pattern,temp)){
                    int posDot = temp.indexOf(".");
                    if (posDot <= 0) return;
                    if (temp.length() - posDot - 1 > 2)
                    {
                        edt.delete(posDot + 3, posDot + 4);
                    }
                }

            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
        });
    }

    @Override
    public void onClick(View v) {
        if(v==button1){
            Intent intent = new Intent(MainActivity.this, CoordinatLayout1Activity.class);
            startActivity(intent);
        }else if(v==button2){
            Intent intent = new Intent(MainActivity.this, CoordinatLayout2Activity.class);
            startActivity(intent);
        } else if(v==button3){
            Intent intent = new Intent(MainActivity.this, CoordinatLayout3Activity.class);
            startActivity(intent);
        }else if(v==button4){
            Intent intent = new Intent(MainActivity.this, CoordinatLayout4Activity.class);
            startActivity(intent);
        }else if(v==button5){
            Intent intent = new Intent(MainActivity.this, CoordinatLayout5Activity.class);
            startActivity(intent);

        }else if(v==button6){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    }
}