package com.example.johncarter.thelon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by john carter on 12/4/2016.
 */

public class BadgeBadgeRecycler extends RecyclerView.Adapter<BadgeBadgeRecycler.ViewHolder> {


    private int badgeImage[] = {R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,
            R.drawable.movie01,};


    private String badgeTitle[] = {"Tooth Fairy",
            "Green Thumb",
            "Dirt Defiant",
            "Coral Chief",
            "Artisan Crafter",
            "Fixer Upper",
            "Eye Candy",
            "Socialite",
            "Foodie",
            "Nobel"};



    @Override
    public BadgeBadgeRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.badge_badge_layout,parent,false);
        BadgeBadgeRecycler.ViewHolder viewHolder = new BadgeBadgeRecycler.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BadgeBadgeRecycler.ViewHolder holder, int position) {


        holder.mBadgeTitle.setText(badgeTitle[position]);
        holder.mBadgeImage.setImageResource(badgeImage[position]);

    }

    @Override
    public int getItemCount() {
        return badgeTitle.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mBadgeImage;
        TextView mBadgeTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            mBadgeImage = (ImageView) itemView.findViewById(R.id.badgebadgePic);
            mBadgeTitle = (TextView) itemView.findViewById(R.id.badgebadgeName);
        }
    }
}
