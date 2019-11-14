package com.example.geeknews.minap;

import com.example.geeknews.base.ZhuanXiang;
import com.example.geeknews.minam.MinMedloXiang;
import com.example.geeknews.minam.MinabackllXiang;

import okhttp3.ResponseBody;

public class MinaPertentXiang {
    public void Retrofit(final MinaViewXiang minaViewXiang,int id){
        MinMedloXiang medloXiang = new MinMedloXiang();
        medloXiang.Retrofit(new MinabackllXiang() {
            @Override
            public void ChengGong(ZhuanXiang zhuanXiang) {
                if (minaViewXiang!=null && zhuanXiang!=null){
                    minaViewXiang.Cheng(zhuanXiang);
                }
            }

            @Override
            public void ShiBai(Throwable e) {
                if (minaViewXiang!=null && e!=null){
                    minaViewXiang.Shi(e);
                }
            }
        },id);
    }
}
