package com.zjh.appui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.zjh.appui.adapter.AdapterGoods;
import com.zjh.appui.beans.GoodsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.rv_goods)
    RecyclerView recyclerView;

    AdapterGoods adapterGoods;

    static final Handler  m = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view);
        ButterKnife.bind(this);
        initData();


        new Thread(new Runnable() {
            public Handler mHandler;
            @Override
            public void run() {
                Looper.prepare();

                mHandler = new Handler(){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);

                        System.out.println("receive msg >>>"+msg.obj);
                    }
                };


                int i =0;
                do{
                    Message msg = Message.obtain();
                    msg.obj = "hello world";
                    mHandler.sendMessage(msg);
                 i++;

                }while (i<100);
                Looper.loop();

            }
        }).start();


    }


    private void initData(){
        List<GoodsBean> data = new ArrayList<>();
        GoodsBean goodsBean = null;
        for (int i=0;i<10;i++){
            goodsBean = new GoodsBean();
            data.add(goodsBean);
        }
        adapterGoods = new AdapterGoods(R.layout.rv_item_good_view,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterGoods);

    }
}
