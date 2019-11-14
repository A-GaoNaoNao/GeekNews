package com.example.geeknews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.base.ZhuanXiang;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc3 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ZhuanXiang.StoriesBean> list;

    public MyadaperRecyc3(Context context, ArrayList<ZhuanXiang.StoriesBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_xiang, parent, false);
        return new XiangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        XiangHolder xiangHolder = (XiangHolder) holder;
        xiangHolder.tv.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImages().get(0)).into(xiangHolder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickZhuanler!=null){
                    clickZhuanler.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class XiangHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public XiangHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_xiang);
            tv = itemView.findViewById(R.id.tv_xiang);
        }
    }

    public interface ClickZhuanler{
        void click(int index);
    }
    private ClickZhuanler clickZhuanler;

    public void setClickZhuanler(ClickZhuanler clickZhuanler) {
        this.clickZhuanler = clickZhuanler;
    }
}
