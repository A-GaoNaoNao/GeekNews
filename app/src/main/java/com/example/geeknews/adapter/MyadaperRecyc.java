package com.example.geeknews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.base.BannerList;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyadaperRecyc extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<com.example.geeknews.base.BannerList.TopStoriesBean> bannerlist;
    private ArrayList<com.example.geeknews.base.BannerList.StoriesBean> itemlist;
    private ArrayList<String> titles;
    private int mPosition;

    public MyadaperRecyc(Context context, ArrayList<com.example.geeknews.base.BannerList.TopStoriesBean> bannerlist, ArrayList<com.example.geeknews.base.BannerList.StoriesBean> itemlist, ArrayList<String> titles) {
        this.context = context;
        this.bannerlist = bannerlist;
        this.itemlist = itemlist;
        this.titles = titles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_banner, parent, false);
            return new BannerList(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new ItemList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        if (type == 1){
            BannerList bannerList = (BannerList) holder;
            bannerList.banner.setImages(bannerlist);
            bannerList.banner.setImageLoader(new ImageLoad());
            bannerList.banner.setBannerTitles(titles);
            bannerList.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            bannerList.banner.start();
        }
        if (type == 2){
            mPosition = position;
            if (bannerlist.size()>0){
                mPosition-=1;
            }
            ItemList itemList = (ItemList) holder;
            itemList.title.setText(itemlist.get(mPosition).getTitle());
            com.example.geeknews.base.BannerList.StoriesBean storiesBean = itemlist.get(mPosition);
            List<String> images = storiesBean.getImages();
            for (int i = 0; i < images.size(); i++) {
                Glide.with(context).load(images.get(i)).into(itemList.iv);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickRiler!=null){
                    clickRiler.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (bannerlist.size()>0){
            return itemlist.size()+1;
        }
        return itemlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;
        }else {
            return 2;
        }
    }

    class BannerList extends RecyclerView.ViewHolder {
        private Banner banner;
        public BannerList(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class ItemList extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        public ItemList(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ri_iv_item);
            title = itemView.findViewById(R.id.ri_tv_item);
        }
    }
    class ImageLoad extends ImageLoader{
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            com.example.geeknews.base.BannerList.TopStoriesBean img = (com.example.geeknews.base.BannerList.TopStoriesBean) path;
            String image = img.getImage();
            Glide.with(context).load(image).into(imageView);
        }
    }

    public interface ClickRiler{
        void click(int index);
    }
    private ClickRiler clickRiler;

    public void setClickRiler(ClickRiler clickRiler) {
        this.clickRiler = clickRiler;
    }
}
