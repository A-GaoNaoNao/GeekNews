package com.example.geeknews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.base.QianList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc_Qian extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<QianList.ResultsBean> list;

    public MyadaperRecyc_Qian(Context context, ArrayList<QianList.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_gan, parent, false);
            return new ItemHolderShang(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.layout_qian_item, parent, false);
        return new ItemHolderXia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        if (type == 1){
            ItemHolderShang itemHolderShang = (ItemHolderShang) holder;
        }
        if (type == 2){
            int mPosition = position;
            ItemHolderXia itemHolderXia = (ItemHolderXia) holder;
            String publishedAt = list.get(mPosition-1).getPublishedAt();
            String[] ts = publishedAt.split("T");
            itemHolderXia.shi.setText(ts[0]);
            itemHolderXia.name.setText(list.get(mPosition-1).getWho());
            itemHolderXia.desc.setText(list.get(mPosition-1).getDesc());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position>0) {
                    if (clickQian != null) {
                        clickQian.click(position - 1);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;
        }else {
            return 2;
        }
    }
    class ItemHolderShang extends RecyclerView.ViewHolder {
        private ImageView iv;
        public ItemHolderShang(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_gan);
        }
    }
    class ItemHolderXia extends RecyclerView.ViewHolder {
        private TextView desc;
        private TextView name;
        private TextView shi;
        public ItemHolderXia(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.tv_qian_desc);
            name = itemView.findViewById(R.id.tv_qian_name);
            shi = itemView.findViewById(R.id.tv_qian_shi);
        }
    }

    public interface ClickQian{
        void click(int index);
    }
    private ClickQian clickQian;

    public void setClickQian(ClickQian clickQian) {
        this.clickQian = clickQian;
    }
}
