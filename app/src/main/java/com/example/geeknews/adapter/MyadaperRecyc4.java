package com.example.geeknews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.base.ReMenList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc4 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ReMenList.RecentBean> list;

    public MyadaperRecyc4(Context context, ArrayList<ReMenList.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_re, parent, false);
        return new ReMenListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ReMenListHolder reMenListHolder = (ReMenListHolder) holder;
        reMenListHolder.tv.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbnail()).into(reMenListHolder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickReler!=null){
                    clickReler.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ReMenListHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ReMenListHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_re);
            tv = itemView.findViewById(R.id.tv_re);
        }
    }

    public interface ClickReler{
        void click(int index);
    }
    private ClickReler clickReler;

    public void setClickReler(ClickReler clickReler) {
        this.clickReler = clickReler;
    }
}
