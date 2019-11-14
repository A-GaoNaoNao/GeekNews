package com.example.geeknews;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.geeknews.adapter.MyadaperFragment_xi;
import com.example.geeknews.fragment.Xi_tab_Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Xi_Fragment extends Fragment {


    public TabLayout tab;
    public ImageView iv;
    public ViewPager pager;

    public static String[] Tabs = {"ANDROID", "IOS", "前端", "后端", "设计", "产品", "阅读", "工具资源"};
    public Xi_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xi_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab_xi);
        iv = view.findViewById(R.id.iv_xi);
        pager = view.findViewById(R.id.pager_xi);

        ArrayList<Xi_tab_Fragment> list = new ArrayList<>();

        for (int i = 0; i < Tabs.length - 4; i++) {
            Xi_tab_Fragment xi_tab_fragment = new Xi_tab_Fragment();
            list.add(xi_tab_fragment);
        }
        MyadaperFragment_xi myadaperFragment_xi = new MyadaperFragment_xi(getChildFragmentManager(), list, Tabs);

        pager.setAdapter(myadaperFragment_xi);

        tab.setupWithViewPager(pager);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),XiTu_Activity.class));
            }
        });
    }
}
