package com.example.johncarter.thelon;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.fragments.BadgeDetailsFragment;

import java.util.ArrayList;

/**
 * Created by dell on 12/1/2016.
 */

public class BadgeAdapter extends RecyclerView.Adapter<BadgeAdapter.ViewHolder>{

//    ArrayList<BadgesModel> badge;
    Context mContext;

    public BadgeAdapter(Context context){
        mContext = context;
    }

    private String[] names = {"Tooth-fairy",
            "Green thumb",
            "Dirt defiant",
            "Coral chief",
            "Artisan crafter",
            "Fixer upper",
            "Eye-candy",
            "Socialite",
            "Foodie",
            "Nobel"};

    private int[] images = {R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black
    };


    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView badgeName;
        private ImageView badgeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            badgeName = (TextView) itemView.findViewById(R.id.badgeName);
            badgeImage = (ImageView) itemView.findViewById(R.id.badgeImage);

            FragmentManager fm;
            fm = ((Activity)mContext).getFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putInt("position", 0);

            BadgeDetailsFragment fragobj = new BadgeDetailsFragment();
            fragobj.setArguments(bundle);
            fm.beginTransaction().replace(R.id.frame1, fragobj).commit();

            badgeImage.setOnClickListener(new View.OnClickListener() {
                FragmentManager fm;
                @Override
                public void onClick(View v) {
                    fm = ((Activity)mContext).getFragmentManager();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", getAdapterPosition());

                    BadgeDetailsFragment fragobj = new BadgeDetailsFragment();
                    fragobj.setArguments(bundle);
                    fm.beginTransaction().replace(R.id.frame1, fragobj).commit();

                }
            });

        }
    }

    @Override
    public BadgeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.badge_item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        holder.badgeName.setText(names[position]);
        holder.badgeImage.setImageResource(images[position]);
    }


    @Override
    public int getItemCount() {
        return names.length;
    }
}
