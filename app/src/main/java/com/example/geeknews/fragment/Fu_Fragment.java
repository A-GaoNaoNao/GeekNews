package com.example.geeknews.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adapter.MyadaperRecyc_Fu;
import com.example.geeknews.base.FuList;
import com.example.geeknews.pertent.MinaViewAndroid;
import com.example.geeknews.pertent.Minaper_Fu;
import com.example.geeknews.webview.Fu_Web_Activity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fu_Fragment extends Fragment implements MinaViewAndroid, OnRefreshListener, OnLoadMoreListener, MyadaperRecyc_Fu.ClickFu {


    public RecyclerView re;
    public ArrayList<FuList.ResultsBean> resultsBeans;
    public MyadaperRecyc_Fu myadaperRecyc_fu;
    public SmartRefreshLayout smar;
    public Minaper_Fu minaper_fu;
    private int id = 1;

    public Fu_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fu_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re_fu);
        smar = view.findViewById(R.id.smar_fu);

        smar.setOnRefreshListener(this);
        smar.setOnLoadMoreListener(this);

        re.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        resultsBeans = new ArrayList<>();

        myadaperRecyc_fu = new MyadaperRecyc_Fu(getContext(), resultsBeans);

        re.setAdapter(myadaperRecyc_fu);

        minaper_fu = new Minaper_Fu();
        minaper_fu.getFu(id);
        minaper_fu.setMinaViewAndroid(this);

        myadaperRecyc_fu.setClickFu(this);
    }

    @Override
    public void Cheng(Object o) {
        if (o instanceof FuList){
            ArrayList<FuList.ResultsBean> results = (ArrayList<FuList.ResultsBean>) ((FuList) o).getResults();
            resultsBeans.addAll(results);
            myadaperRecyc_fu.notifyDataSetChanged();
        }
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        id = 1;
        minaper_fu.getFu(id);
        resultsBeans.clear();
        smar.finishRefresh(true);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        id++;
        minaper_fu.getFu(id);
        smar.finishLoadMore(true);
    }

    @Override
    public void click(int index) {
        String url = resultsBeans.get(index).getUrl();
        Intent intent = new Intent(getContext(), Fu_Web_Activity.class);
        intent.putExtra("url_fu",url);
        startActivity(intent);
    }
}
