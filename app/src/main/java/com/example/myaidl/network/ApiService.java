package com.example.myaidl.network;

import com.example.myaidl.bean.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService  {

    @GET("top250")
    Observable<Movie> getTopMovies(@Query("start") int start, @Query("count") int count);
}
