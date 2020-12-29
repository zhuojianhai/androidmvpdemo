package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import com.example.myaidl.IZJHAidl;
import com.example.myaidl.bean.Book;
import com.example.myapplication.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //得到远程服务的句柄
    IZJHAidl izjhAidl;

    Button bindBtn;
    Button addBtn;
    Button getBtn;
    TextView tv;

    FloatingActionButton fab;

    boolean isConnectioned = false;

    int index = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        bindBtn = findViewById(R.id.btn_bind_service);
        addBtn = findViewById(R.id.btn_add_book);
        getBtn = findViewById(R.id.btn_get_book);

        tv = findViewById(R.id.tv_content);

        bindListener();

    }

    private void bindListener() {
        bindBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);
        fab.setOnClickListener(this);
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            izjhAidl = IZJHAidl.Stub.asInterface(service);
            isConnectioned = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnectioned = false;
        }
    };

    private void bindServerService() {

        Intent intent = new Intent();
        intent.setPackage("com.example.myaidl");
        intent.setAction("com.example.myaidl.services.myService");


        bindService(intent, connection, BIND_AUTO_CREATE);


    }



    private void addBookToServer(){
        Book book = new Book();
        book.setBookId(index);
        book.setBookName("天龙八部"+index);
        book.setBookPublisher("云南大理出版社"+index);
        try {
            izjhAidl.addBook(book);
            index +=10;
            tv.setText("重置内容区域");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == bindBtn) {
            bindServerService();
        } else if (v == addBtn) {

            if(isConnectioned){
                addBookToServer();
            }else{
                Toast.makeText(this,"服务还未绑定",Toast.LENGTH_LONG).show();
            }


        } else if (v == getBtn) {
            if(isConnectioned){
                try {
                    tv.setText(izjhAidl.getBookList().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(this,"服务还未绑定", Toast.LENGTH_LONG).show();
            }
        }else if(v == fab){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}