package com.example.geeknews.adapter;

import com.example.geeknews.fragment.Xi_tab_Fragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyadaperFragment_xi extends FragmentPagerAdapter {
    private ArrayList<Xi_tab_Fragment> list;
    private String[] Tabs;

    public MyadaperFragment_xi(@NonNull FragmentManager fm, ArrayList<Xi_tab_Fragment> list, String[] tabs) {
        super(fm);
        this.list = list;
        Tabs = tabs;
    }

    public MyadaperFragment_xi(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Tabs[position];
    }
}
