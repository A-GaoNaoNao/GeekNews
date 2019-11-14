package com.example.geeknews.minap;

import com.example.geeknews.base.ReMenList;
import com.example.geeknews.minam.MinaMedloRe;
import com.example.geeknews.minam.MinabackllRe;

public class MinaPertentRe {
    public void Retrofit(final MinaViewRe minaViewRe){
        MinaMedloRe medloRe = new MinaMedloRe();
        medloRe.Retrofit(new MinabackllRe() {
            @Override
            public void ChengGong(ReMenList reMenList) {
                if (minaViewRe!=null && reMenList!=null){
                    minaViewRe.Cheng(reMenList);
                }
            }

            @Override
            public void ShiBai(Throwable e) {
                if (minaViewRe!=null && e!=null){
                    minaViewRe.Shi(e);
                }
            }
        });
    }
}
