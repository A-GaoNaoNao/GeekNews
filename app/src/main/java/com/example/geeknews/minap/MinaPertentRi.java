package com.example.geeknews.minap;

import com.example.geeknews.base.BannerList;
import com.example.geeknews.minam.MinaMedloRi;
import com.example.geeknews.minam.MinabackllRi;

public class MinaPertentRi {
    public void Retrofit(final MinaViewRi minaViewRi){
        MinaMedloRi medloRi = new MinaMedloRi();
        medloRi.Retrofit(new MinabackllRi() {
            @Override
            public void ChengGong(BannerList bannerList) {
                if (minaViewRi!=null && bannerList!=null){
                    minaViewRi.Cheng(bannerList);
                }
            }

            @Override
            public void ShiBai(Throwable e) {
                if (minaViewRi!=null && e!=null){
                    minaViewRi.Shi(e);
                }
            }
        });
    }
}
