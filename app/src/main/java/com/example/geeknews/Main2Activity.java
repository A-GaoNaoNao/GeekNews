package com.example.geeknews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.geeknews.adapter.MyadaperRecyc2;
import com.example.geeknews.adapter.MyadaperRecyc3;
import com.example.geeknews.base.ZhuanLuan;
import com.example.geeknews.base.ZhuanXiang;
import com.example.geeknews.minap.MinaPertentXiang;
import com.example.geeknews.minap.MinaViewXiang;
import com.example.geeknews.minap.MinaViewZhuan;
import com.example.geeknews.webview.Zhuan_Web_Activity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements MinaViewXiang, MyadaperRecyc3.ClickZhuanler {


    private ArrayList<ZhuanXiang.StoriesBean> storiesBeans;
    private MyadaperRecyc3 myadaperRecyc3;
    private RecyclerView re;
    private Toolbar toolbar;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_zhuan);
        re = findViewById(R.id.re_xiang);
        title = findViewById(R.id.tv_title_zhuan);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        toolbar.setTitle("");
        title.setText(name);

        setSupportActionBar(toolbar);
        re.setLayoutManager(new LinearLayoutManager(this));

        int id = intent.getIntExtra("id", 1);

        Log.i("Gao", "initView: "+id);

        storiesBeans = new ArrayList<>();

        myadaperRecyc3 = new MyadaperRecyc3(this, storiesBeans);

        re.setAdapter(myadaperRecyc3);
        MinaPertentXiang minaPertentXiang = new MinaPertentXiang();
        minaPertentXiang.Retrofit(this,id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        myadaperRecyc3.setClickZhuanler(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Cheng(ZhuanXiang zhuanXiang) {
        ArrayList<ZhuanXiang.StoriesBean> stories = (ArrayList<ZhuanXiang.StoriesBean>) zhuanXiang.getStories();
        storiesBeans.addAll(stories);
        myadaperRecyc3.notifyDataSetChanged();
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        String url = storiesBeans.get(index).getUrl();
        Intent intent = new Intent(Main2Activity.this, Zhuan_Web_Activity.class);
        intent.putExtra("url_zhuan",url);
        startActivity(intent);
    }
}
