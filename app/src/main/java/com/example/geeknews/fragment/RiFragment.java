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
import com.example.geeknews.base.BannerList;
import com.example.geeknews.minap.MinaPertentRi;
import com.example.geeknews.minap.MinaViewRi;
import com.example.geeknews.webview.Ri_Web_Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiFragment extends Fragment implements MinaViewRi, MyadaperRecyc.ClickRiler {


    private RecyclerView re;
    private ArrayList<BannerList.TopStoriesBean> topStoriesBeans;
    private ArrayList<BannerList.StoriesBean> storiesBeans;
    private MyadaperRecyc myadaperRecyc;
    private ArrayList<String> titles;

    public RiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ri, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re);

        re.setLayoutManager(new LinearLayoutManager(getContext()));

        topStoriesBeans = new ArrayList<>();

        storiesBeans = new ArrayList<>();

        titles = new ArrayList<>();

        myadaperRecyc = new MyadaperRecyc(getContext(),topStoriesBeans, storiesBeans,titles);

        re.setAdapter(myadaperRecyc);

        MinaPertentRi minaPertentRi = new MinaPertentRi();
        minaPertentRi.Retrofit(this);

        myadaperRecyc.setClickRiler(this);
    }

    @Override
    public void Cheng(BannerList bannerList) {
        ArrayList<BannerList.TopStoriesBean> top_stories = (ArrayList<BannerList.TopStoriesBean>) bannerList.getTop_stories();
        topStoriesBeans.addAll(top_stories);
        for (int i = 0; i < top_stories.size(); i++) {
            String title = top_stories.get(i).getTitle();
            titles.add(title);
        }
        ArrayList<BannerList.StoriesBean> stories = (ArrayList<BannerList.StoriesBean>) bannerList.getStories();
        storiesBeans.addAll(stories);
        myadaperRecyc.notifyDataSetChanged();
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        String url = storiesBeans.get(index).getUrl();
        Intent intent = new Intent(getContext(), Ri_Web_Activity.class);
        intent.putExtra("url_ri",url);
        startActivity(intent );
    }
}
