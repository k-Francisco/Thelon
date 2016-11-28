package com.example.johncarter.thelon.home_details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.johncarter.thelon.R;

/**
 * Created by john carter on 11/28/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private int[] images = { R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.emovie,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i};

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.itemImage);
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item_staggered,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
