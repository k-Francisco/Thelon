package com.example.johncarter.thelon.admin_side;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.johncarter.thelon.R;

/**
 * Created by asus on 03/12/2016.
 */

public class AssociatedPicsAdapter extends RecyclerView.Adapter<AssociatedPicsAdapter.ViewHolder> {
    private int images[] = {
            R.drawable.feed1,
            R.drawable.feed2,
            R.drawable.feed3,
            R.drawable.feed4,
            R.drawable.feed5,
            R.drawable.feed6};
    @Override
    public AssociatedPicsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ascpics,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AssociatedPicsAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.feedPics);
        }
    }
}
