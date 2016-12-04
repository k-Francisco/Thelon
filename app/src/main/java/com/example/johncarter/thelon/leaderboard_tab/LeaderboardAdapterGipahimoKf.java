package com.example.johncarter.thelon.leaderboard_tab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by asus on 05/12/2016.
 */

public class LeaderboardAdapterGipahimoKf extends RecyclerView.Adapter<LeaderboardAdapterGipahimoKf.ViewHolder> {


    private String[] Texts= {
            "Lorem Epsum",
            "Lorem Epsum",
            "Lorem Epsum"
    };

    private String[] points = {
            "2000",
            "2000",
            "2000"
    };
    private int[] Badge = {
            R.drawable.kobe,
            R.drawable.kobe,
            R.drawable.kobe

    };
    private int[] picture = {
            R.drawable.anton,
            R.drawable.anton,
            R.drawable.anton
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gipahimonikfngalayoutleaderboard,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(Texts[position]);
        holder.points.setText(points[position]);
        holder.badge.setImageResource(Badge[position]);
        holder.image.setImageResource(picture[position]);
    }

    @Override
    public int getItemCount() {
        return picture.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private ImageView badge;
        private TextView text;
        private TextView points;


        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.pic);
            badge = (ImageView)itemView.findViewById(R.id.badge);
            text = (TextView)itemView.findViewById(R.id.text);
            points = (TextView)itemView.findViewById(R.id.points);
        }
    }
}
