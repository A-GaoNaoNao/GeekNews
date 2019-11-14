package com.example.geeknews.medlo;

import android.content.Context;

import com.example.geeknews.ApiService;
import com.example.geeknews.base.BaseApp;
import com.example.geeknews.baseurl.BaseUrl;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MinaMedlo {

    public Context context;

    private MinaMedlo(){}
    private volatile static MinaMedlo minaMedlo;

    public static MinaMedlo getInstance(){
        if (minaMedlo == null){
            synchronized (MinaMedlo.class){
                if (minaMedlo == null){
                    minaMedlo = new MinaMedlo();
                }
            }
        }
        return minaMedlo;
    }


    public ApiService getApiser(){
        context = BaseApp.getContext();
        File cacheDir = context.getCacheDir();
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(cacheDir,1024*1024*10))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BaseUrl.BASE_URL_GAN)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;
    }

    public ApiService getMeiVn(){
        File cacheDir = context.getCacheDir();
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(cacheDir,1024*1024*10))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BaseUrl.BASE_MV2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;
    }
}
