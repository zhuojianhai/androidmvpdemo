package com.example.myapplication.dagger2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.myapplication.R;
import com.example.myapplication.dagger2.bean.Menu;
import com.example.myapplication.dagger2.impl.Chef;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Map<String, Boolean> menus = new LinkedHashMap<>();
        menus.put("酸菜鱼", true);
        menus.put("土豆丝", true);
        menus.put("铁板牛肉", true);
        Menu menu = new Menu(menus);
        Chef chef = new Chef(menu);
        System.out.println(chef.cook());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Intent intent = new Intent(this,DaggerMenuActivity.class);
                startActivity(intent);
                break;
        }
        return super.onTouchEvent(event);
    }
}
