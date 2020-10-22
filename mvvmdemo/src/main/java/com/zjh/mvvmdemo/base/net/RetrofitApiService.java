package com.zjh.mvvmdemo.base.net;

import com.zjh.mvvmdemo.base.model.BannerBean;
import com.zjh.mvvmdemo.base.model.ResponModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

interface RetrofitApiService {
    //wanAndroid的banner
    @GET("banner/json")
    Observable<ResponModel<List<BannerBean>>> getBanner();
}
