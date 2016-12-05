package com.example.johncarter.thelon.admin_side;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by john carter on 12/3/2016.
 */

public class FoundationActivitiesAdapter extends RecyclerView.Adapter<FoundationActivitiesAdapter.ViewHolder> {


    private String[] activityNames = {"Feeding Program",
            "Dental Mission",
            "Tree Planting",
            "COP",
            "Disaster Relief",
            "Fun Run for a Cause",
            "Blood Donation Campaign",
            "Blood Letting Campaign",
            "Libre Tuli Operation",
            "Sport Campaign"};

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

    @Override
    public FoundationActivitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_foundation_profile_layout,parent,false);
        FoundationActivitiesAdapter.ViewHolder viewHolder = new FoundationActivitiesAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mActivityName.setText(activityNames[position]);
        holder.mActivityImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return activityNames.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mActivityName;
        private ImageView mActivityImage;

        public ViewHolder(View itemView) {
            super(itemView);

            mActivityImage = (ImageView) itemView.findViewById(R.id.activity_image);
            mActivityName = (TextView) itemView.findViewById(R.id.activity_name);
        }
    }
}
