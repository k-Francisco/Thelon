package com.example.johncarter.thelon.admin_side;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class AdminHomeAdapter extends RecyclerView.Adapter<AdminHomeAdapter.ViewHolder>{

    private Context context;

    public AdminHomeAdapter(Context context){
        this.context = context;
    }

    private String[] nums = {
            "40",
            "120"
    };

    private String[] nums2 = {
            "Activities",
            "Volunteers"
    };

    private String[] msg = {
            "Other hand, we denounce",
            "Other hand, we denounce"
    };

    private int[] images = {
            R.drawable.ic_heart_red,
            R.drawable.ic_heart_red,};

    private int[] images2 = {
            R.drawable.c1,
            R.drawable.c2,};

    @Override
    public AdminHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_home,parent,false);
        ViewHolder viewHolder = new ViewHolder (v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdminHomeAdapter.ViewHolder holder, int position) {
        holder.num.setText(nums[position]);
        holder.numDesc.setText(nums2[position]);
        holder.text.setText(msg[position]);
        holder.actPic.setImageResource(images[position]);
        holder.actBack.setImageResource(images2[position]);
    }

    @Override
    public int getItemCount() {
        return nums.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView num, numDesc, text;
        private ImageView actPic;
        private FrameLayout fl;
        private ImageView actBack;

        public ViewHolder(final View itemView) {
            super(itemView);
            num = (TextView) itemView.findViewById(R.id.number);
            numDesc = (TextView) itemView.findViewById(R.id.numberDesc);
            text = (TextView) itemView.findViewById(R.id.chartext);
            actPic = (ImageView)itemView.findViewById(R.id.charpic);
            actBack = (ImageView) itemView.findViewById(R.id.charlesgwapo);
            actBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = ((Activity)context).getFragmentManager();
                    fm.beginTransaction().replace(R.id.menu_frame,new ActivityList_admin()).commit();
                }
            });
        }
    }
}
