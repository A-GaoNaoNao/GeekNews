package com.example.geeknews.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adapter.MyadaperRecyc;
import com.example.geeknews.adapter.MyadaperRecyc_Android;
import com.example.geeknews.base.Gan_Android;
import com.example.geeknews.baseurl.BaseUrl;
import com.example.geeknews.pertent.MinaViewAndroid;
import com.example.geeknews.pertent.Minper_Android;
import com.example.geeknews.webview.Android_Web_Activity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Android_Fragment extends Fragment implements MinaViewAndroid, OnRefreshListener, OnLoadMoreListener, MyadaperRecyc_Android.ClickAndroid {


    public RecyclerView re;
    public ArrayList<Gan_Android.ResultsBean> resultsBeans;
    public MyadaperRecyc_Android myadaperRecyc_android;
    public SmartRefreshLayout smar;
    public Minper_Android minper_android;
    private int id = 1;

    public Android_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_android_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re_android);
        smar = view.findViewById(R.id.smar_android);

        smar.setOnRefreshListener(this);
        smar.setOnLoadMoreListener(this);
        re.setLayoutManager(new LinearLayoutManager(getContext()));

        resultsBeans = new ArrayList<>();

        myadaperRecyc_android = new MyadaperRecyc_Android(getContext(), resultsBeans);

        re.setAdapter(myadaperRecyc_android);


        minper_android = new Minper_Android();
        minper_android.setMinaViewAndroid(this);
        minper_android.Retrofit(id);

        myadaperRecyc_android.setClickAndroid(this);
    }

    @Override
    public void Cheng(Object o) {
        if (o instanceof Gan_Android){
            ArrayList<Gan_Android.ResultsBean> results = (ArrayList<Gan_Android.ResultsBean>) ((Gan_Android) o).getResults();
            resultsBeans.addAll(results);
            myadaperRecyc_android.notifyDataSetChanged();
        }
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        id = 1;
        resultsBeans.clear();
        minper_android.Retrofit(id);
        smar.finishRefresh(true);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        id++;
        minper_android.Retrofit(id);
        smar.finishLoadMore(true);
    }

    @Override
    public void click(int index) {
        String url = resultsBeans.get(index).getUrl();
        String desc = resultsBeans.get(index).getDesc();
        Intent intent = new Intent(getContext(), Android_Web_Activity.class);
        intent.putExtra("url_android",url);
        intent.putExtra("url_desc",desc);
        startActivity(intent);
    }
}
