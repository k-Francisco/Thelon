package com.example.johncarter.thelon.profile_tab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class BadgeListAdapter extends RecyclerView.Adapter<BadgeListAdapter.ViewHolder>{


    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    private String[] names = {"Tooth-fairy(novice)", "Green-thumb(novice)", "Dirt-defiant(novice)", "Coral chief(novice)"};
    private String[] points = {"20","20","20","20"};
    private String[] date = {"Jan. 15, 2016","Mar. 23, 2016", "Oct. 24, 2016", "Dec. 25, 2016"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.badge_list_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.badgeImg.setImageResource(images[position]);
        holder.badgeName.setText(names[position]);
        holder.badgePoints.setText(points[position]);
        holder.badgeDate.setText(date[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView badgeImg;
        TextView badgeName, badgePoints, badgeDate;
        public ViewHolder(View itemView) {
            super(itemView);

            badgeImg = (ImageView)itemView.findViewById(R.id.badgeImg);
            badgeName = (TextView)itemView.findViewById(R.id.badgeName);
            badgePoints = (TextView)itemView.findViewById(R.id.badgePoints);
            badgeDate = (TextView)itemView.findViewById(R.id.badgeDate);

        }
    }
}
