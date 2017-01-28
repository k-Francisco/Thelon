package com.example.johncarter.thelon.admin_side;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;

/**
 * Created by Acer on 28/01/2017.
 */

public class AssociatedPicsAdapter2 extends RecyclerView.Adapter<AssociatedPicsAdapter2.ViewHolder> {

    private ArrayList<Bitmap> ascPics = new ArrayList<>();

    public AssociatedPicsAdapter2(ArrayList<Bitmap> bitmap) {
        this.ascPics = bitmap;
    }

    @Override
    public AssociatedPicsAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ascpics,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AssociatedPicsAdapter2.ViewHolder holder, int position) {
        holder.imageView.setImageBitmap(ascPics.get(position));
    }

    @Override
    public int getItemCount() {
        return ascPics.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.feedPics);
        }
    }
}
