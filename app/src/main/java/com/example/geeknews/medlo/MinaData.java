package com.example.geeknews.medlo;

import com.example.geeknews.ApiService;
import com.example.geeknews.base.Gan_Android;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MinaData {
    public void getData(String url, Observer<ResponseBody> observer){
        MinaMedlo instance = MinaMedlo.getInstance();
        ApiService apiser = instance.getApiser();
        apiser.getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getFuli(String url,Observer<ResponseBody> observer){
        MinaMedlo instance = MinaMedlo.getInstance();
        ApiService meiVn = instance.getMeiVn();
        meiVn.getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
