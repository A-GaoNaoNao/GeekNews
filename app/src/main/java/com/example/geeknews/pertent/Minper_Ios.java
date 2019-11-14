package com.example.geeknews.pertent;

import com.example.geeknews.base.IosList;
import com.example.geeknews.baseurl.BaseUrl;
import com.example.geeknews.medlo.MinaData;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class Minper_Ios {

    private MinaData minaData;

    private MinaViewAndroid minaViewAndroid;

    private int id = 1;

    public void setMinaViewAndroid(MinaViewAndroid minaViewAndroid) {
        this.minaViewAndroid = minaViewAndroid;
    }

    public Minper_Ios(){
        minaData = new MinaData();
    }

    public void getIos(int id){
        minaData.getData(BaseUrl.BASE_IOS+id, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String json = responseBody.string();
                    IosList iosList = new Gson().fromJson(json, IosList.class);
                    if (minaViewAndroid!=null && iosList!=null){
                        minaViewAndroid.Cheng(iosList);
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
