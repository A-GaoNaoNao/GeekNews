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
import com.example.geeknews.adapter.MyadaperRecyc_Ios;
import com.example.geeknews.base.IosList;
import com.example.geeknews.pertent.MinaViewAndroid;
import com.example.geeknews.pertent.Minper_Ios;
import com.example.geeknews.webview.Ios_Web_Activity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ios_Fragment extends Fragment implements MinaViewAndroid, OnLoadMoreListener, OnRefreshListener, MyadaperRecyc_Ios.ClickIos {


    public RecyclerView re;
    public SmartRefreshLayout smar;
    public ArrayList<IosList.ResultsBean> resultsBeans;
    public MyadaperRecyc_Ios myadaperRecyc_ios;
    public Minper_Ios minper_ios;
    private int id = 1;

    public Ios_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ios_, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re_ios);
        smar = view.findViewById(R.id.smar_ios);

        smar.setOnLoadMoreListener(this);
        smar.setOnRefreshListener(this);
        re.setLayoutManager(new LinearLayoutManager(getContext()));

        resultsBeans = new ArrayList<>();

        myadaperRecyc_ios = new MyadaperRecyc_Ios(getContext(), resultsBeans);

        re.setAdapter(myadaperRecyc_ios);

        minper_ios = new Minper_Ios();
        minper_ios.setMinaViewAndroid(this);
        minper_ios.getIos(id);

        myadaperRecyc_ios.setClickIos(this);
    }

    @Override
    public void Cheng(Object o) {
        if (o instanceof IosList){
            ArrayList<IosList.ResultsBean> results = (ArrayList<IosList.ResultsBean>) ((IosList) o).getResults();
            resultsBeans.addAll(results);
            myadaperRecyc_ios.notifyDataSetChanged();
        }
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        id++;
        minper_ios.getIos(id);
        smar.finishLoadMore(true);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        id = 1;
        minper_ios.getIos(id);
        resultsBeans.clear();
        smar.finishRefresh(true);
    }

    @Override
    public void click(int index) {
        String url = resultsBeans.get(index).getUrl();
        String desc = resultsBeans.get(index).getDesc();
        Intent intent = new Intent(getContext(), Ios_Web_Activity.class);
        intent.putExtra("url_ios",url);
        intent.putExtra("desc_ios",desc);
        startActivity(intent);
    }
}
