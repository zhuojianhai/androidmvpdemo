package com.zjh.mvvmdemo.base.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;
    private RetrofitApiService retrofitApiService;
    private RetrofitManager() {
        initRetrofit();
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public static RetrofitApiService getApiService() {
        return retrofitManager.retrofitApiService;
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
//                .baseUrl(SystemConst.DEFAULT_SERVER)
                .baseUrl("SystemConst.DEFAULT_SERVER")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }

}
