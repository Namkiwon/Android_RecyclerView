package com.example.namgiwon.android_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by namgiwon on 2018. 1. 23..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder>{
    ArrayList<ListviewVO> items;
    Context context;
    public RecyclerAdapter(Context context ,ArrayList<ListviewVO> items){
        this.context = context;
        this.items = items;
    }

    public void add(ListviewVO item) {
        Log.d("시발","add해줘");
        this.items.add(item);
        notifyItemInserted(items.size()-1);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ListviewVO item = items.get(position);
        holder.name.setText(item.getName());
        holder.sno.setText(item.getSno());

        //Glide 라이브러리를 사용한 이미지 로딩  (은근 더 빠른것 같다)
//        Glide.with(context).load(item.getImgPath()).into(holder.image);
        Glide.with(context).load(item.getImgPath()).bitmapTransform(new CropCircleTransformation(context)).into(holder.image);

//        holder.image.setImageResource(R.mipmap.ic_launcher_round);
//        BringPhoto bp = new BringPhoto(item.getImgPath(),holder.image);
//        bp.execute();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
