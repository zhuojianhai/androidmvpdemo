package com.example.myaidl.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;


/***
 * http 缓存策略
 * 在http协议中，定义了一些缓存相关的header
 *
 * cache-control
 *
 * ETag、 If-None_match
 *
 *
 * LastMofified、if-modified-since
 *
 *
 * Expired
 *
 *
 *
 * cache-control,即缓存策略。它直接关系到客户端是否使用缓存、请求和相应。分别有这些值：
 *
 * 请求：
 * no-cache:不使用缓存实体，直接从服务器去取
 * only-if-cached:不进行与网络相关的请求交互，只返回已经缓存且满足要求的数据，    否则返回504错误
 * max-age:缓存可使用最大时间
 * max-stale：已过期的缓存在多长时间内仍可以使用，
 * min-fresh：最小新鲜度，只接受当前age和min-fresh值之和的缓存对象
 *
 * 响应：
 *
 *  public:缓存的内容可以给任何用户
 *  private：只能返回给之前请求的用户
 *  no-cache：缓存服务器不对任何资源进行缓存
 *  no-store：不缓存
 *  max-age：本响应包含的对象过期的时间
 *
 */
public class MyOkhttpUtils {

    public void show(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Response response =  chain.proceed(original);
                return response;
            }
        }).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        })
                .build();


        RequestBody rb = new RequestBody() {
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        };
        Request request = new Request.Builder().post(rb).build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
