package com.example.myaidl.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myaidl.R;

import org.w3c.dom.Text;

public class CoordinatLayout1Activity extends AppCompatActivity {

    private TextView tv;
    private TextView tv_child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinat_layout1);
        tv = findViewById(R.id.tv_msg);
        tv_child = findViewById(R.id.tv_child);

        RecyclerView recyclerView = new RecyclerView(this);



        //子线程可以更新ui组件哦
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    String threnam = Thread.currentThread().getName();
                    tv_child.setText(threnam+ "-----哈里斯道格拉斯结果到了该结束了大概就是了商量过了建设管理局\n 帝国理工就算了");
                    tv_child.requestLayout();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //showChildMessageQueue();

        tv.append("Thread.currentThread().getName() " +Thread.currentThread().getName()+"\n");

        System.out.println(">>>>>>"+Looper.getMainLooper().hashCode());

       // show();
    }

    private void showSpannableString(){
        SpannableString spannableString = new SpannableString("连手机格拉斯哥十来个");
        //设置前景色
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE),1,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


    }


    private void showChildMessageQueue(){
      Thread t =   new Thread(new Runnable() {

          Handler mChildHandler = new Handler(){
              @Override
              public void handleMessage(@NonNull Message msg) {
                  super.handleMessage(msg);
                  String rs = Thread.currentThread().getName()+" "+ msg.obj.toString()+"\n";
                  tv.append(rs);
                  Log.e("线程："+Thread.currentThread().getName(),msg.obj.toString());
              }
          };

      //    MyHandler mChildHandler  = new MyHandler(Looper.myLooper());

          @Override
            public void run() {
                //Looper.prepare();

//              System.out.println(">>>>>>"+Looper.myLooper().hashCode());
                int i=0;
                while(i<10){
                    Message msg = Message.obtain();
                    msg.obj = "this is message "+i;
                    mChildHandler.sendMessage(msg );
                    i++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//                Looper.loop();
            }
        });

      t.start();


    }


    private void show(){
        new Thread(new Runnable() {
            Handler h;

            @Override
            public void run() {

                    Looper.prepare();

                     h = new Handler(){
                        @Override
                        public void handleMessage(@NonNull Message msg) {
                            super.handleMessage(msg);

                            Log.e(Thread.currentThread().getName(),msg.obj.toString());
                        }
                    };
                    Dialog dialog = null;
                    AlertDialog.Builder   builder     = new AlertDialog.Builder(CoordinatLayout1Activity.this);
                    dialog = builder.create();
                    LinearLayout linearLayout = new LinearLayout(CoordinatLayout1Activity.this);

                    TextView textView = new TextView(CoordinatLayout1Activity.this);
                    textView.setText("打了十几个垃圾山东理工快结束了干净利索塑料管技术");


                    linearLayout.addView(textView);
                    dialog.setContentView(linearLayout);

                    dialog.show();

                    Toast.makeText(CoordinatLayout1Activity.this,"this is childThread",Toast.LENGTH_LONG).show();

                    int i =0;

                    while (i<100) {
                        Message msg = Message.obtain();
                        msg.obj = "only child Thread "+i;
                        h.sendMessageDelayed(msg,500);
                        i++;


                    }
                    Looper.loop();

            }
        }).start();
    }

    class MyHandler extends Handler{
        Looper looper;
        public MyHandler(Looper looper){
            this.looper = looper;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            String rs = Thread.currentThread().getName()+" "+ msg.obj.toString()+"\n";
                  tv.append(rs);
                  Log.e("childThread",msg.obj.toString());
        }
    }

}
