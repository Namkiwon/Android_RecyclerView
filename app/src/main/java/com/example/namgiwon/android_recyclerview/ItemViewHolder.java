package com.example.namgiwon.android_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by namgiwon on 2018. 1. 23..
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView sno;
    public ImageView image;

    public ItemViewHolder(View itemView){
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        sno = (TextView) itemView.findViewById(R.id.sno);
        image = (ImageView) itemView.findViewById(R.id.img);
    }
}
