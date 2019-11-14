package com.example.geeknews;

import com.example.geeknews.base.BannerList;
import com.example.geeknews.base.ReMenList;
import com.example.geeknews.base.ZhuanLuan;
import com.example.geeknews.base.ZhuanXiang;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiService {
    @GET("http://news-at.zhihu.com/api/4/news/latest")
    Observable<BannerList>getBannerList();

    @GET("http://news-at.zhihu.com/api/4/sections")
    Observable<ZhuanLuan>getZhuanLuan();

    @GET("http://news-at.zhihu.com/api/4/section/{path}")
    Observable<ZhuanXiang>getRequest(@Path("path")int path);

    @GET("http://news-at.zhihu.com/api/4/news/hot")
    Observable<ReMenList>getRimenList();

    @GET
    Observable<ResponseBody>getData(@Url String url);
}
