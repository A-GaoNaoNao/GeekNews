package com.example.geeknews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.geeknews.adapter.MyadaperFragment;
import com.example.geeknews.base.TabList;
import com.example.geeknews.fragment.RekFragment;
import com.example.geeknews.fragment.RiFragment;
import com.example.geeknews.fragment.ZhuFragment;
import com.example.geeknews.fragment.ZhuanFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dr;
    private Toolbar toolbar;
    private NavigationView nav;
    private Zhi_Fragment zhi_fragment;
    private Wei_Fragment wei_fragment;
    private Gan_Fragment gan_fragment;
    private Xi_Fragment xi_fragment;
    private V2EX_Fragment v2EX_fragment;
    private ShouFragment shouFragment;
    private SheFragment sheFragment;
    private GuanFragment guanFragment;
    private MaterialSearchView serchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        dr = findViewById(R.id.dr);
        nav = findViewById(R.id.nav);
        serchview = findViewById(R.id.search_view);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("知乎日报");

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dr, toolbar, R.string.app_name, R.string.app_name);

        toggle.syncState();


        nav.setItemIconTintList(null);

        nav.setNavigationItemSelectedListener(this);

        zhi_fragment = new Zhi_Fragment();
        wei_fragment = new Wei_Fragment();
        gan_fragment = new Gan_Fragment();
        xi_fragment = new Xi_Fragment();
        v2EX_fragment = new V2EX_Fragment();
        shouFragment = new ShouFragment();
        sheFragment = new SheFragment();
        guanFragment = new GuanFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fram_zhi,zhi_fragment);
        transaction.add(R.id.fram_zhi,wei_fragment);
        transaction.add(R.id.fram_zhi,gan_fragment);
        transaction.add(R.id.fram_zhi,xi_fragment);
        transaction.add(R.id.fram_zhi,v2EX_fragment);
        transaction.add(R.id.fram_zhi,shouFragment);
        transaction.add(R.id.fram_zhi,sheFragment);
        transaction.add(R.id.fram_zhi,guanFragment);


        transaction.show(zhi_fragment).hide(wei_fragment);
        transaction.show(zhi_fragment).hide(gan_fragment);
        transaction.show(zhi_fragment).hide(xi_fragment);
        transaction.show(zhi_fragment).hide(v2EX_fragment);
        transaction.show(zhi_fragment).hide(sheFragment);
        transaction.show(zhi_fragment).hide(shouFragment);
        transaction.show(zhi_fragment).hide(guanFragment);

        transaction.commit();
    }

    public MaterialSearchView getSerchView(){
        if (serchview!=null){
            return serchview;
        }
        return null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()){
            case R.id.item_zhi:
                toolbar.setTitle("知乎日报");
                transaction.show(zhi_fragment)
                        .hide(wei_fragment)
                        .hide(gan_fragment)
                        .hide(xi_fragment)
                        .hide(v2EX_fragment)
                        .hide(shouFragment)
                        .hide(sheFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                break;
            case R.id.item_wei:
                toolbar.setTitle("微信精选");
                transaction.show(wei_fragment)
                        .hide(zhi_fragment)
                        .hide(gan_fragment)
                        .hide(xi_fragment)
                        .hide(v2EX_fragment)
                        .hide(shouFragment)
                        .hide(sheFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                    break;
            case R.id.item_gan:
                toolbar.setTitle("干货集中营");
                transaction.show(gan_fragment)
                        .hide(wei_fragment)
                        .hide(zhi_fragment)
                        .hide(xi_fragment)
                        .hide(v2EX_fragment)
                        .hide(shouFragment)
                        .hide(sheFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                break;
            case R.id.item_xi:
                toolbar.setTitle("稀土掘金");
                transaction.show(xi_fragment)
                        .hide(wei_fragment)
                        .hide(gan_fragment)
                        .hide(zhi_fragment)
                        .hide(v2EX_fragment)
                        .hide(shouFragment)
                        .hide(sheFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                break;
            case R.id.item_v:
                toolbar.setTitle("V2EX");
                transaction.show(v2EX_fragment)
                        .hide(wei_fragment)
                        .hide(gan_fragment)
                        .hide(xi_fragment)
                        .hide(zhi_fragment)
                        .hide(shouFragment)
                        .hide(sheFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                break;
            case R.id.item_show:
                toolbar.setTitle("收藏");
                transaction.show(shouFragment)
                        .hide(zhi_fragment)
                        .hide(wei_fragment)
                        .hide(gan_fragment)
                        .hide(xi_fragment)
                        .hide(v2EX_fragment)
                        .hide(sheFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                break;
            case R.id.item_she:
                toolbar.setTitle("设置");
                transaction.show(sheFragment)
                        .hide(wei_fragment)
                        .hide(gan_fragment)
                        .hide(xi_fragment)
                        .hide(v2EX_fragment)
                        .hide(zhi_fragment)
                        .hide(shouFragment)
                        .hide(guanFragment)
                        .commit();
                dr.closeDrawers();
                break;
            case R.id.item_guan:
                toolbar.setTitle("关于");
                transaction.show(guanFragment)
                        .hide(wei_fragment)
                        .hide(gan_fragment)
                        .hide(xi_fragment)
                        .hide(v2EX_fragment)
                        .hide(zhi_fragment)
                        .hide(sheFragment)
                        .hide(shouFragment)
                        .commit();
                dr.closeDrawers();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (serchview.isSearchOpen()){
            serchview.closeSearch();
        }else {
            super.onBackPressed();
        }
    }
}
