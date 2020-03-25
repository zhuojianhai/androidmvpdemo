package com.example.myaidl.network;

import com.example.myaidl.bean.Movie;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiMethods {

    /**
     * 封装线程管理和订阅的过程
     */
    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getTopMovie(Observer<Movie> observer,int start,int count){
        ApiSubscribe(Api.getApiService().getTopMovies(start,count),observer);
    }
}
