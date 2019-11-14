package com.example.geeknews.GreenDao;

import android.database.sqlite.SQLiteDatabase;

import com.example.geeknews.base.BaseApp;

public class MyappNews {
    private static MyappNews myappNews;

    private MyappNews(){}

    public synchronized static MyappNews getMyappNews(){
        if (myappNews == null){
            synchronized (MyappNews.class){
                if (myappNews == null){
                    myappNews = new MyappNews();
                }
            }
        }
        return myappNews;
    }

    public DaoSession getDaoSession(){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(BaseApp.getContext(), "news.db");
        SQLiteDatabase database = openHelper.getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }
}
