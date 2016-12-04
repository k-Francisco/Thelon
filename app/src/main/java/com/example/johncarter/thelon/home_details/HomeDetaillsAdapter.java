package com.example.johncarter.thelon.home_details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by john carter on 11/29/2016.
 */

public class HomeDetaillsAdapter extends RecyclerView.Adapter<HomeDetaillsAdapter.ViewHolder>{
    @Override
    public HomeDetaillsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_details2,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.joinBtn.setImageResource(R.drawable.ic_attendance);
        //holder.referBtn.setImageResource(R.drawable.ic_cancelBtn);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView joinBtn,referBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            joinBtn = (ImageView) itemView.findViewById(R.id.joinBtn);
            referBtn = (ImageView) itemView.findViewById(R.id.referBtn);
        }
    }
}
