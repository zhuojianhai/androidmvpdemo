package com.example.myaidl.network;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
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
    OkHttpClient okHttpClient = null;
    public MyOkhttpUtils(){
        okHttpClient = new OkHttpClient.Builder().build();
    }
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
        }).connectionPool(new ConnectionPool(10,10, TimeUnit.MINUTES))
                .dns(Dns.SYSTEM)
                .build();
        okHttpClient.dispatcher().setMaxRequests(100);
        okHttpClient.dispatcher().setMaxRequestsPerHost(20);


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

    /**
     * 使用java 原生的URLConnection去执行网络请求
     *
     * @param path
     */
    public void showUrlconnction(String path){
        URLConnection urlConnection;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            URL url = new URL(path);
            //打开和URl之间的连接
            urlConnection = url.openConnection();

            //设置通用属性
            urlConnection.setRequestProperty("accept","*/*");
            urlConnection.setRequestProperty("connection","keep-Alive");
            urlConnection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            //建立实际的链接
            urlConnection.connect();

            //得到输出流，发送请求数据
            outputStream = urlConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(outputStream));

            outputStreamWriter.write("version=10");
            outputStreamWriter.flush();
            outputStreamWriter.close();

            //得到输入流，得到请求的内容
            inputStream = urlConnection.getInputStream();

        }catch (Exception e){
            e.printStackTrace();

        }finally {

            try {
                if (outputStream!=null){
                    outputStream.close();
                }
                if (outputStreamWriter!=null){
                    outputStreamWriter.close();
                }

                if (inputStream!=null){
                    inputStream.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public static void setSelfSign() throws Exception{
        //创建sslContext对象，设置信任管理器
        SSLContext sslContext = SSLContext.getInstance("TLS");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        //
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        //清空默认证书信息，设置自己证书
        keyStore.load(null);

        CertificateFactory cf = CertificateFactory.getInstance("X.509");



    }

    public static void setCertificates(InputStream... certificates){

        try
        {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates)
            {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try
                {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e)
                {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslContext.getSocketFactory());
//            builder.sslSocketFactory(sslContext.getSocketFactory(),  trustManagerFactory.getTrustManagers());


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void shows() throws Exception {

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        trustManagerFactory.init((KeyStore) null);

       TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

      if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
         throw new IllegalStateException("Unexpected default trust managers:"
                             + Arrays.toString(trustManagers));
     }

      X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

       SSLContext sslContext = SSLContext.getInstance("TLS");

       sslContext.init(null, new TrustManager[] { trustManager }, null);

       SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();


       OkHttpClient client = new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, trustManager).build();
    }
}
