package com.example.johncarter.thelon.leaderboard_tab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

import java.util.List;

/**
 * Created by john carter on 11/26/2016.
 */

public class LeaderBoardAdapter extends ArrayAdapter<LeaderBoardModel> {

    private Context mContext;
    private int mResource;
    private List<LeaderBoardModel> mLeaderBoard;

    public LeaderBoardAdapter(Context context, int resource, List<LeaderBoardModel> objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
        mLeaderBoard = objects;

    }

    static class ViewHolder{

        TextView volunteerName;
        TextView volunteerPoints;
        ImageView volunteerImage;
        ImageView volunteerRank;

            public ViewHolder(View view){

                volunteerName = (TextView) view.findViewById(R.id.leaderboard_name);
                volunteerPoints = (TextView) view.findViewById(R.id.leaderboard_points);
                volunteerImage = (ImageView) view.findViewById(R.id.leaderboard_pic);
                volunteerRank = (ImageView) view.findViewById(R.id.leaderboard_rank);

            }
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){

            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LeaderBoardModel leaderBoard = mLeaderBoard.get(position);
        if (leaderBoard != null){

            if (viewHolder.volunteerName != null){
                viewHolder.volunteerName.setText(leaderBoard.getName());
            }

            if (viewHolder.volunteerPoints != null){
                viewHolder.volunteerPoints.setText(leaderBoard.getPoints());
            }

            if (viewHolder.volunteerImage != null){
                viewHolder.volunteerImage.setImageResource(leaderBoard.getVolunteerImage());
            }

            if (viewHolder.volunteerRank != null){
                viewHolder.volunteerRank.setImageResource(leaderBoard.getRankingImage());
            }
        }

        return convertView;
    }
}
