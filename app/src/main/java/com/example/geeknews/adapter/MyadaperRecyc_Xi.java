package com.example.geeknews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.geeknews.GreenDao.DaoSession;
import com.example.geeknews.GreenDao.MyappNews;
import com.example.geeknews.GreenDao.NewsDao;
import com.example.geeknews.GreenDao.NewsDaoDao;
import com.example.geeknews.R;
import com.example.geeknews.Xi_Fragment;
import com.example.geeknews.jiekou.ItemCallBack;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc_Xi extends RecyclerView.Adapter implements ItemCallBack {
    public DaoSession daoSession;
    private Context context;
    private ArrayList<String> list;

    public MyadaperRecyc_Xi(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
        daoSession = MyappNews.getMyappNews().getDaoSession();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_sy_item, parent, false);
        return new ShouYeItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ShouYeItem shouYeItem = (ShouYeItem) holder;

        NewsDao newsDao = daoSession.queryBuilder(NewsDao.class).where(NewsDaoDao.Properties.MPosition.eq(position + "")).build().unique();
        shouYeItem.swi.setChecked(newsDao.getChecked());

        shouYeItem.swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                NewsDao newsDao1 = new NewsDao();
                newsDao1.setId((long) (position+1));
                newsDao1.setTitle(Xi_Fragment.Tabs[position]);
                newsDao1.setChecked(isChecked);
                newsDao1.setMPosition(position);
                daoSession.update(newsDao1);
            }
        });
        shouYeItem.tv.setText(list.get(position));
        shouYeItem.swi.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void moveItem(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);


    }

    @Override
    public void deleteItem(int deleteItemPosition) {
        list.remove(deleteItemPosition);
        notifyItemRemoved(deleteItemPosition);
    }

    class ShouYeItem extends RecyclerView.ViewHolder {
        private TextView tv;
        private SwitchCompat swi;
        public ShouYeItem(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_shou);
            swi = itemView.findViewById(R.id.swi);
        }
    }
}
