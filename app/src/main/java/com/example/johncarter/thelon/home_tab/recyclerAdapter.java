package com.example.johncarter.thelon.home_tab;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by john carter on 11/28/2016.
 */

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {


    private String[] actName = {"Feeding Program",
            "Disaster Relief",
            "Children Vaccination",
            "Tuli Operation",
            "Dental Mission",
            "Feeding Program",
            "Disaster Relief",
            "Medical Mission"};

    private String[] actDetails = {"Rise Above Foundation",
            "Ramon Aboitiz Foundation Inc.", "Rise Above Foundation",
            "Ramon Aboitiz Foundation Inc.", "Rise Above Foundation",
            "Ramon Aboitiz Foundation Inc.", "Rise Above Foundation",
            "Ramon Aboitiz Foundation Inc."};

    private String[] actHost = {"Lorem Epsum",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = {R.drawable.home_backpic,
            R.drawable.home_backpic,
            R.drawable.home_backpic,
            R.drawable.home_backpic,
            R.drawable.home_backpic,
            R.drawable.home_backpic,
            R.drawable.home_backpic,
            R.drawable.home_backpic};

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemImage, joinBtn, referBtn;
        public TextView activityName, activityDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            activityName = (TextView) itemView.findViewById(R.id.activityName);
            activityDetails = (TextView) itemView.findViewById(R.id.activityDetails);
            joinBtn = (ImageView) itemView.findViewById(R.id.joinBtn);
            referBtn = (ImageView) itemView.findViewById(R.id.referBtn);

            itemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent();
//                    intent.setClass(v.getContext(),ActivityDetails.class);
//                    v.getContext().startActivity(intent);
                }
            });

            joinBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Click detected on joinBtn", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });

            referBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Click detected on referBtn", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });



        }
    }

    @Override
    public recyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(recyclerAdapter.ViewHolder holder, int position) {
        holder.itemImage.setImageResource(images[position]);
        holder.activityName.setText(actName[position]);
        holder.activityDetails.setText(actDetails[position]);
    }

    @Override
    public int getItemCount() {
        return actName.length;
    }
}
