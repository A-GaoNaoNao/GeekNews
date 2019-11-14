package com.example.geeknews.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.geeknews.GreenDao.DaoSession;
import com.example.geeknews.GreenDao.MyappNews;
import com.example.geeknews.GreenDao.NewsDao;
import com.example.geeknews.GreenDao.NewsDaoDao;
import com.example.geeknews.Xi_Fragment;

import java.util.HashMap;

public class BaseApp extends Application {
    private static Context mContext;
    private static SharedPreferences mSharedPreferences;
    private static HashMap<String,Object> map;
    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        map = new HashMap<String, Object>();
        daoSession = MyappNews.getMyappNews().getDaoSession();
        initData();
    }

    private void initData() {
        NewsDaoDao newsDaoDao = daoSession.getNewsDaoDao();
        for (int i = 0; i < Xi_Fragment.Tabs.length; i++) {
            NewsDao newsDao = new NewsDao();
            newsDao.setId((long) (i + 1));
            newsDao.setTitle(Xi_Fragment.Tabs[i]);
            newsDao.setMPosition(i);
            switch (i){
                case 0:
                case 1:
                case 2:
                case 3:
                    newsDao.setChecked(true);
                    break;
                default:
                    newsDao.setChecked(false);
                    break;
            }
            newsDaoDao.insert(newsDao);
        }
    }

    //全局上下文
    public static Context getContext(){
        return mContext;
    }

    //全局SharedPreferences整个程序能使用
    public static SharedPreferences getmSharedPreferences(){
        if (mSharedPreferences != null){
            return mSharedPreferences;
        }
        return null;
    }

    //Map集合存储
    public static void putObj(String key,Object object){
        if (map!=null){
            map.put(key,object);
        }
    }
    //Map中集合中取出
    public static Object getObj(String key){
        if (map!=null && map.size()>0)
            return map.get(key);
        return null;
    }

    public static void clearMap(){
        if (map!=null){
            map.clear();
            map = null;
        }
    }
}
