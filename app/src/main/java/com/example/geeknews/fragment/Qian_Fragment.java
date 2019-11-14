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
import com.example.geeknews.adapter.MyadaperRecyc_Qian;
import com.example.geeknews.base.QianList;
import com.example.geeknews.pertent.MinaViewAndroid;
import com.example.geeknews.pertent.Minaper_Qian;
import com.example.geeknews.webview.Qian_Web_Activity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Qian_Fragment extends Fragment implements OnRefreshListener, OnLoadMoreListener, MinaViewAndroid, MyadaperRecyc_Qian.ClickQian {


    public RecyclerView re;
    public SmartRefreshLayout smar;
    public ArrayList<QianList.ResultsBean> resultsBeans;
    public MyadaperRecyc_Qian myadaperRecyc_qian;
    public Minaper_Qian minaper_qian;
    private int id = 1;

    public Qian_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qian_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initViwe(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initViwe(View view) {
        re = view.findViewById(R.id.re_qian);
        smar = view.findViewById(R.id.smar_qian);

        re.setLayoutManager(new LinearLayoutManager(getContext()));

        smar.setOnRefreshListener(this);
        smar.setOnLoadMoreListener(this);

        resultsBeans = new ArrayList<>();

        myadaperRecyc_qian = new MyadaperRecyc_Qian(getContext(), resultsBeans);

        re.setAdapter(myadaperRecyc_qian);

        minaper_qian = new Minaper_Qian();
        minaper_qian.getQian(id);
        minaper_qian.setMinaViewAndroid(this);

        myadaperRecyc_qian.setClickQian(this);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        id = 1;
        minaper_qian.getQian(id);
        resultsBeans.clear();
        smar.finishRefresh(true);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        id++;
        minaper_qian.getQian(id);
        smar.finishLoadMore(true);
    }

    @Override
    public void Cheng(Object o) {
        if (o instanceof QianList){
            ArrayList<QianList.ResultsBean> results = (ArrayList<QianList.ResultsBean>) ((QianList) o).getResults();
            resultsBeans.addAll(results);
            myadaperRecyc_qian.notifyDataSetChanged();
        }
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        String url = resultsBeans.get(index).getUrl();
        String desc = resultsBeans.get(index).getDesc();
        Intent intent = new Intent(getContext(), Qian_Web_Activity.class);
        intent.putExtra("url_qian",url);
        intent.putExtra("desc_qian",desc);
        startActivity(intent);
    }
}
