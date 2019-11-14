package com.example.geeknews.pertent;

import com.example.geeknews.base.FuList;
import com.example.geeknews.base.Gan_Android;
import com.example.geeknews.baseurl.BaseUrl;
import com.example.geeknews.medlo.MinaData;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class Minaper_Fu {
    private MinaData minaData;

    private int id = 1;

    public Minaper_Fu(){
        minaData = new MinaData();
    }

    private MinaViewAndroid minaViewAndroid;

    public void setMinaViewAndroid(MinaViewAndroid minaViewAndroid) {
        this.minaViewAndroid = minaViewAndroid;
    }

    public void getFu(int id){
        minaData.getData(BaseUrl.BASE_FU+id, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String json = responseBody.string();
                    FuList fuList = new Gson().fromJson(json, FuList.class);
                    if (minaViewAndroid != null && fuList!=null){
                        minaViewAndroid.Cheng(fuList);
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
