package com.example.johncarter.thelon.portfolio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.VolunteerContactAdapter;
import com.example.johncarter.thelon.home_details.home_details_joined;

/**
 * Created by john carter on 12/4/2016.
 */

public class portfolioAdapter2 extends RecyclerView.Adapter<portfolioAdapter2.ViewHolder> {



    private String[] title = {
            "Feeding Program",
            "Dental Mission",
            "Tree Planting",
            "Community Outreach",
            "Disaster Relief",
            "Fun Run for a Cause",
            "Blood Donation Campaign",
            "Blood Letting Campaign",
            "Libre Tuli Operation",
            "Sport Campaign"};

    private int status[] = {
            R.drawable.ic_bookmark_upcoming,
            R.drawable.ic_bookmark_upcoming,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,};

    private int[] images = {R.drawable.feed1,
            R.drawable.dental_mission,
            R.drawable.tree_planting,
            R.drawable.community_outreach,
            R.drawable.disaster_relief,
            R.drawable.fun_run,
            R.drawable.blood_donation,
            R.drawable.blood_letting,
            R.drawable.libre_tuli,
            R.drawable.sports_campaign};

    private String[] desc = {"This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            "This program reminds me of that kid that inspired me a lot to do good things",
            };





    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_layout,parent,false);
        portfolioAdapter2.ViewHolder viewHolder = new portfolioAdapter2.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(title[position]);
        holder.desc.setText(desc[position]);
        holder.pic.setImageResource(images[position]);
        holder.status.setImageResource(status[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, desc;
        private ImageView pic, status;

        public ViewHolder(final View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.portfolio_card_title);
            desc = (TextView) itemView.findViewById(R.id.portfolio_card_desc);
            pic = (ImageView) itemView.findViewById(R.id.portfolio_card_image);
            status = (ImageView) itemView.findViewById(R.id.portfolio_card_status);

            status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),home_details_joined.class));
                }
            });
        }
    }
}
