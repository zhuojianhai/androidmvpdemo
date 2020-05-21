package com.example.myaidl.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.myaidl.R;
import com.example.myaidl.custom.MyTouchView;

public class TouchViewActivity extends AppCompatActivity {

    MyTouchView myTouchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_view);
        myTouchView = findViewById(R.id.my_touchEvent);

        myTouchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchViewActivity.this,"点击了",Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView recyclerView = new RecyclerView(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /***
     *
     *     public void onUserInteraction() {
     *         super.onUserInteraction();
     *     }
     *
     *
     *  public boolean dispatchTouchEvent(MotionEvent ev) {
     *         if (ev.getAction() == MotionEvent.ACTION_DOWN) {
     *             onUserInteraction();
     *         }
     *         if (getWindow().superDispatchTouchEvent(ev)) {
     *             return true;
     *         }
     *         return onTouchEvent(ev);
     *     }
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


}
