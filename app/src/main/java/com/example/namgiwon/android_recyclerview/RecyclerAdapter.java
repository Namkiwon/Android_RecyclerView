package com.example.namgiwon.android_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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


//            }
//        }
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
        holder.image.setImageResource(R.mipmap.ic_launcher_round);
        BringPhoto bp = new BringPhoto(item.getImgPath(),holder.image);
        bp.execute();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
