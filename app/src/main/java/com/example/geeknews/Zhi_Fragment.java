package com.example.geeknews;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.adapter.MyadaperFragment;
import com.example.geeknews.base.TabList;
import com.example.geeknews.fragment.RekFragment;
import com.example.geeknews.fragment.RiFragment;
import com.example.geeknews.fragment.ZhuFragment;
import com.example.geeknews.fragment.ZhuanFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Zhi_Fragment extends Fragment {



    private TabLayout tab;
    private ViewPager pager;

    public Zhi_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zhi_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {

        tab = view.findViewById(R.id.tab_zhi);

        pager = view.findViewById(R.id.pager_zhi);


        ArrayList<TabList> tabLists = new ArrayList<>();
        tabLists.add(new TabList("日报"));
        tabLists.add(new TabList("主题"));
        tabLists.add(new TabList("专栏"));
        tabLists.add(new TabList("热门"));

        ArrayList<Fragment> fragments = new ArrayList<>();
        RiFragment riFragment = new RiFragment();
        ZhuanFragment zhuanFragment = new ZhuanFragment();
        ZhuFragment zhuFragment = new ZhuFragment();
        RekFragment rekFragment = new RekFragment();

        fragments.add(riFragment);
        fragments.add(zhuFragment);
        fragments.add(zhuanFragment);
        fragments.add(rekFragment);


        MyadaperFragment myadaperFragment = new MyadaperFragment(getChildFragmentManager(), fragments);

        pager.setAdapter(myadaperFragment);

        tab.setupWithViewPager(pager);

        for (int i = 0; i < fragments.size(); i++) {
            tab.getTabAt(i).setText(tabLists.get(i).getName());
        }
    }
}
