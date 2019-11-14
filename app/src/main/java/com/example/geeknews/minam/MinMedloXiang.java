package com.example.geeknews.minam;

import com.example.geeknews.ApiService;
import com.example.geeknews.base.ZhuanXiang;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MinMedloXiang {
    private int id;
    public void Retrofit(final MinabackllXiang minabackllXiang,int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getRequest(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuanXiang>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuanXiang zhuanXiang) {
                        if (minabackllXiang!=null){
                            minabackllXiang.ChengGong(zhuanXiang);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (minabackllXiang!=null){
                            minabackllXiang.ShiBai(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
