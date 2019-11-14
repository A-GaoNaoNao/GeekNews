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
import com.example.geeknews.adapter.MyadaperRecyc3;
import com.example.geeknews.adapter.MyadaperRecyc4;
import com.example.geeknews.base.ReMenList;
import com.example.geeknews.minap.MinaPertentRe;
import com.example.geeknews.minap.MinaViewRe;
import com.example.geeknews.webview.Re_Web_Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RekFragment extends Fragment implements MinaViewRe, MyadaperRecyc4.ClickReler {


    private RecyclerView re;
    private ArrayList<ReMenList.RecentBean> recentBeans;
    private MyadaperRecyc4 myadaperRecyc4;

    public RekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rek, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re_re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));

        recentBeans = new ArrayList<>();

        myadaperRecyc4 = new MyadaperRecyc4(getContext(), recentBeans);

        re.setAdapter(myadaperRecyc4);

        MinaPertentRe minaPertentRe = new MinaPertentRe();
        minaPertentRe.Retrofit(this);

        myadaperRecyc4.setClickReler(this);
    }

    @Override
    public void Cheng(ReMenList reMenList) {
        ArrayList<ReMenList.RecentBean> recent = (ArrayList<ReMenList.RecentBean>) reMenList.getRecent();
        recentBeans.addAll(recent);
        myadaperRecyc4.notifyDataSetChanged();
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        String url = recentBeans.get(index).getUrl();
        Intent intent = new Intent(getContext(), Re_Web_Activity.class);
        intent.putExtra("url_re",url);
        startActivity(intent);
    }
}
