package com.example.geeknews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.base.FuList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc_Fu extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<FuList.ResultsBean> list;

    public MyadaperRecyc_Fu(Context context, ArrayList<FuList.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_fu, parent, false);
        return new ItemFuList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ItemFuList itemFuList = (ItemFuList) holder;
        Log.i("Gao", "onBindViewHolder: "+position);
        Glide.with(context).load(list.get(position).getUrl()).into(itemFuList.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickFu!=null){
                    clickFu.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemFuList extends RecyclerView.ViewHolder {
        private ImageView iv;
        public ItemFuList(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_fu);
        }
    }

    public interface ClickFu{
        void click(int index);
    }
    private ClickFu clickFu;

    public void setClickFu(ClickFu clickFu) {
        this.clickFu = clickFu;
    }
}
