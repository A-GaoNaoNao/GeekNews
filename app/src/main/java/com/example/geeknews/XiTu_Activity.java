package com.example.geeknews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.geeknews.GreenDao.DaoSession;
import com.example.geeknews.GreenDao.MyappNews;
import com.example.geeknews.SimpItem.SimpleItemTouch;
import com.example.geeknews.adapter.MyadaperRecyc_Xi;
import com.example.geeknews.jiekou.ItemCallBack;

import java.util.ArrayList;

public class XiTu_Activity extends AppCompatActivity {

    public RecyclerView re;
    public MyadaperRecyc_Xi myadaperRecyc_xi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_tu_);
        initView();
    }

    private void initView() {
        re = findViewById(R.id.re_xi);

        re.setLayoutManager(new LinearLayoutManager(this));

        re.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Xi_Fragment.Tabs.length; i++) {
            list.add(Xi_Fragment.Tabs[i]);
        }

        myadaperRecyc_xi = new MyadaperRecyc_Xi(this, list);

        re.setAdapter(myadaperRecyc_xi);

        SimpleItemTouch simpleItemTouch = new SimpleItemTouch(myadaperRecyc_xi);
        simpleItemTouch.setItemIsSwip(true);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouch);
        itemTouchHelper.attachToRecyclerView(re);

        MyappNews myappNews = MyappNews.getMyappNews();
        DaoSession daoSession = myappNews.getDaoSession();

    }
}
