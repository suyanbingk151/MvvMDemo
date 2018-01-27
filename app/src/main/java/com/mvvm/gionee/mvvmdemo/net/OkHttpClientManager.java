package com.mvvm.gionee.mvvmdemo.net;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by sulc on 2018/1/17.
 */

public class OkHttpClientManager {

    public static OkHttpClientManager uniqueInstance = null;

    private static final int DEFAULT_TIMEOUT = 60;

    public static OkHttpClient client;

    public static OkHttpClientManager getInstance(){
        if (uniqueInstance ==null){
            synchronized (OkHttpClientManager.class){
                uniqueInstance = new OkHttpClientManager();
            }
        }
        return uniqueInstance;
    }

    public OkHttpClientManager(){
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)//设置写的超时时间
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public OkHttpClient getOkhttpClient(){
        return client;
    }

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.i("retrofitBack",""+message);
        }
    });
}
