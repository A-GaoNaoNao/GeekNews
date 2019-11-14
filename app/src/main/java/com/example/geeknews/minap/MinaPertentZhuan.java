package com.example.geeknews.minap;

import com.example.geeknews.base.BannerList;
import com.example.geeknews.base.ZhuanLuan;
import com.example.geeknews.minam.MinaMedloRi;
import com.example.geeknews.minam.MinaMedloZhuan;
import com.example.geeknews.minam.MinabackllRi;
import com.example.geeknews.minam.MinabackllZhuan;

public class MinaPertentZhuan {
    public void Retrofit(final MinaViewZhuan minaViewZhuan,int id) {
        final MinaMedloZhuan minaMedloZhuan = new MinaMedloZhuan();
        minaMedloZhuan.Retrofit(new MinabackllZhuan() {
            @Override
            public void ChengGong(ZhuanLuan zhuanLuan) {
                if (minaMedloZhuan != null && minaMedloZhuan != null) {
                    minaViewZhuan.Cheng(zhuanLuan);
                }
            }

            @Override
            public void ShiBai(Throwable e) {
                if (minaMedloZhuan != null && e != null) {
                    minaViewZhuan.Shi(e);
                }
            }
        },id);
    }
}
