package com.example.geeknews;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.adapter.MyadaperFragment;
import com.example.geeknews.base.TabList;
import com.example.geeknews.fragment.Android_Fragment;
import com.example.geeknews.fragment.Fu_Fragment;
import com.example.geeknews.fragment.Ios_Fragment;
import com.example.geeknews.fragment.Qian_Fragment;
import com.google.android.material.tabs.TabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gan_Fragment extends Fragment implements MaterialSearchView.OnQueryTextListener {


    private MaterialSearchView serchView;
    public TabLayout tab;
    public ViewPager pager;

    public Gan_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gan_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab_gan);
        pager = view.findViewById(R.id.pager_gan);

        ArrayList<TabList> tabLists = new ArrayList<>();
        tabLists.add(new TabList("Android"));
        tabLists.add(new TabList("ios"));
        tabLists.add(new TabList("前端"));
        tabLists.add(new TabList("福利"));

        ArrayList<Fragment> fragments = new ArrayList<>();
        Android_Fragment android_fragment = new Android_Fragment();
        Ios_Fragment ios_fragment = new Ios_Fragment();
        Qian_Fragment qian_fragment = new Qian_Fragment();
        Fu_Fragment fu_fragment = new Fu_Fragment();
        fragments.add(android_fragment);
        fragments.add(ios_fragment);
        fragments.add(qian_fragment);
        fragments.add(fu_fragment);

        MyadaperFragment myadaperFragment = new MyadaperFragment(getChildFragmentManager(), fragments);

        pager.setAdapter(myadaperFragment);
        tab.setupWithViewPager(pager);

        for (int i = 0; i < fragments.size(); i++) {
            tab.getTabAt(i).setText(tabLists.get(i).getName());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_xuan,menu);
        FragmentActivity activity = getActivity();
        if (activity instanceof MainActivity){
            serchView = ((MainActivity) activity).getSerchView();
            MenuItem item = menu.findItem(R.id.item_search);
            serchView.setMenuItem(item);
            serchView.setOnQueryTextListener(this);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (serchView !=null && serchView.isSearchOpen()){
            Log.i("Gao", query+"======onQueryTextSubmit============");
            serchView.closeSearch();
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("Gao", newText+"=========onQueryTextChange: =======");
        return true;
    }
}
