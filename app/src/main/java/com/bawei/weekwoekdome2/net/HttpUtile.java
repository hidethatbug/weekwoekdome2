package com.bawei.weekwoekdome2.net;

import com.bawei.weekwoekdome2.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:程金柱
 * Date:2019/7/13 10:36
 * Description：
 */

public class HttpUtile {
    private static HttpUtile httpUtile;
    private final Retrofit retrofit;

    private HttpUtile() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .build();
    }

    public static HttpUtile getHttpUtile() {
        if (httpUtile == null) {
            synchronized (HttpUtile.class) {
                if (httpUtile == null) {
                    httpUtile = new HttpUtile();
                }
            }
        }
        return httpUtile;
    }

    /**
     * 动态网络代理
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getRetifit(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
