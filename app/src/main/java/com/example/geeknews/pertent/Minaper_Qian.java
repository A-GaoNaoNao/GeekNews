package com.example.geeknews.pertent;

import com.example.geeknews.base.IosList;
import com.example.geeknews.base.QianList;
import com.example.geeknews.baseurl.BaseUrl;
import com.example.geeknews.medlo.MinaData;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class Minaper_Qian {
    private MinaData minaData;

    private int id = 1;
    public Minaper_Qian(){
        minaData = new MinaData();
    }
    private MinaViewAndroid minaViewAndroid;

    public void setMinaViewAndroid(MinaViewAndroid minaViewAndroid) {
        this.minaViewAndroid = minaViewAndroid;
    }

    public void getQian(int id){
        minaData.getData(BaseUrl.BASE_QIAN+id, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String json = responseBody.string();
                    QianList qianList = new Gson().fromJson(json, QianList.class);
                    if (minaViewAndroid!=null && qianList!=null){
                        minaViewAndroid.Cheng(qianList);
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
