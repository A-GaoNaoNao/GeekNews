package com.example.geeknews.minam;

import com.example.geeknews.ApiService;
import com.example.geeknews.base.BannerList;
import com.example.geeknews.base.ZhuanLuan;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MinaMedloZhuan {
    public void Retrofit(final MinabackllZhuan minabackllZhuan,int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getZhuanLuan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuanLuan>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuanLuan zhuanLuan) {
                        if (minabackllZhuan!=null){
                            minabackllZhuan.ChengGong(zhuanLuan);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (minabackllZhuan!=null){
                            minabackllZhuan.ShiBai(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
