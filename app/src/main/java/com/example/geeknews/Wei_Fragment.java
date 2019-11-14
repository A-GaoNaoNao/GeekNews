package com.example.geeknews;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Wei_Fragment extends Fragment implements MaterialSearchView.OnQueryTextListener {


    private MaterialSearchView serchView;

    public Wei_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wei_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {

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
