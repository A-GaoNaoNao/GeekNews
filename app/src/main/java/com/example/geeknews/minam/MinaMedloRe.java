package com.example.geeknews.minam;

import com.example.geeknews.ApiService;
import com.example.geeknews.base.BannerList;
import com.example.geeknews.base.ReMenList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MinaMedloRe {
    public void Retrofit(final MinabackllRe minabackllRe){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getRimenList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReMenList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReMenList reMenList) {
                        if (minabackllRe!=null){
                            minabackllRe.ChengGong(reMenList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (minabackllRe!=null){
                            minabackllRe.ShiBai(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
