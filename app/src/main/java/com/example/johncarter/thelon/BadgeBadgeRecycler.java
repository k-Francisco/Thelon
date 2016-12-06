package com.example.johncarter.thelon;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
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
Context Mcontext;

    public BadgeBadgeRecycler(Context context) {
        Mcontext = context;
    }


    private int badgeImage[] = {R.drawable.ic_toothbadge,
            R.drawable.ic_greenthumb,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,};


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

        public ViewHolder(final View itemView) {
            super(itemView);

            mBadgeImage = (ImageView) itemView.findViewById(R.id.badgebadgePic);
            mBadgeTitle = (TextView) itemView.findViewById(R.id.badgebadgeName);
            mBadgeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = ((Activity)Mcontext).getFragmentManager();
                    DialogFragmentBadge dialog = new DialogFragmentBadge();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", getAdapterPosition());
                    dialog.setArguments(bundle);
                    dialog.show(fm.beginTransaction().addSharedElement(mBadgeImage, "badgebadge"),"blah2");


                }
            });
        }
    }
}
