package com.example.geeknews.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.Main2Activity;
import com.example.geeknews.R;
import com.example.geeknews.adapter.MyadaperRecyc2;
import com.example.geeknews.base.ZhuanLuan;
import com.example.geeknews.minap.MinaPertentZhuan;
import com.example.geeknews.minap.MinaViewZhuan;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanFragment extends Fragment implements MinaViewZhuan, MyadaperRecyc2.Clicklerzhuan {


    private RecyclerView re;
    private ArrayList<ZhuanLuan.DataBean> dataBeans;
    private MyadaperRecyc2 myadaperRecyc2;
    private int id;

    public ZhuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zhuan, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initView(getView());
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re_zhuan);

        re.setLayoutManager(new GridLayoutManager(getContext(),2));

        dataBeans = new ArrayList<>();

        myadaperRecyc2 = new MyadaperRecyc2(getContext(), dataBeans);

        re.setAdapter(myadaperRecyc2);



        MinaPertentZhuan minaPertentZhuan = new MinaPertentZhuan();
        minaPertentZhuan.Retrofit(this,id);

        myadaperRecyc2.setClicklerzhuan(this);
    }

    @Override
    public void Cheng(ZhuanLuan zhuanLuan) {
        ArrayList<ZhuanLuan.DataBean> data = (ArrayList<ZhuanLuan.DataBean>) zhuanLuan.getData();
        dataBeans.addAll(data);
        myadaperRecyc2.notifyDataSetChanged();
    }

    @Override
    public void Shi(Throwable e) {
        Log.i("Gao", "Shi: "+e);
    }

    @Override
    public void click(int index) {
        Intent intent = new Intent(getContext(), Main2Activity.class);
        String name = dataBeans.get(index).getName();
        intent.putExtra("id",dataBeans.get(index).getId());
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
