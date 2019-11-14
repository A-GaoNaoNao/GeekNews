package com.example.geeknews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.base.ZhuanLuan;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc2 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ZhuanLuan.DataBean> list;

    public MyadaperRecyc2(Context context, ArrayList<ZhuanLuan.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_zhuan, parent, false);
        return new ZhuangList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ZhuangList zhuangList = (ZhuangList) holder;
        zhuangList.name.setText(list.get(position).getName());
        zhuangList.title.setText(list.get(position).getDescription());
        Glide.with(context).load(list.get(position).getThumbnail()).into(zhuangList.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicklerzhuan!=null){
                    clicklerzhuan.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ZhuangList extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView name;
        public ZhuangList(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.zhuan_iv);
            title = itemView.findViewById(R.id.zhuan_tv_title);
            name = itemView.findViewById(R.id.zhuan_tv_name);
        }
    }

    public interface Clicklerzhuan{
        void click(int index);
    }
    private Clicklerzhuan clicklerzhuan;

    public void setClicklerzhuan(Clicklerzhuan clicklerzhuan) {
        this.clicklerzhuan = clicklerzhuan;
    }
}
