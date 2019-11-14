package com.example.geeknews.pertent;

import android.util.Log;

import com.example.geeknews.base.Gan_Android;
import com.example.geeknews.baseurl.BaseUrl;
import com.example.geeknews.medlo.MinaData;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class Minper_Android {

    private MinaData minaData;
    private int id = 1;
    private MinaViewAndroid minaViewAndroid;

    public void setMinaViewAndroid(MinaViewAndroid minaViewAndroid) {
        this.minaViewAndroid = minaViewAndroid;
    }

    public Minper_Android() {
        minaData = new MinaData();
    }

    public void Retrofit(int id){
        minaData.getData(BaseUrl.BASE_ANDROID+id, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String json = responseBody.string();
                    Gan_Android gan_android = new Gson().fromJson(json, Gan_Android.class);
                    if (minaViewAndroid != null && gan_android!=null){
                        minaViewAndroid.Cheng(gan_android);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (minaViewAndroid!=null && e!=null){
                    minaViewAndroid.Shi(e);
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
