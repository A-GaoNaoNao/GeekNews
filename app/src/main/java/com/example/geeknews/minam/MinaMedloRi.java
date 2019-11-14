package com.example.geeknews.minam;

import com.example.geeknews.ApiService;
import com.example.geeknews.base.BannerList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MinaMedloRi {
    public void Retrofit(final MinabackllRi minabackllRi){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getBannerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerList bannerList) {
                        if (minabackllRi!=null){
                            minabackllRi.ChengGong(bannerList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (minabackllRi!=null){
                            minabackllRi.ShiBai(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
