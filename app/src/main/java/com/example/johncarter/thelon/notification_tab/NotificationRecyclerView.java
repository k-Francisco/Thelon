package com.example.johncarter.thelon.notification_tab;

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

public class NotificationRecyclerView extends RecyclerView.Adapter<NotificationRecyclerView.ViewHolder> {

    private String[] name = {"Charles Cruz",
            "Tyler Lim",
            "Kobe Relativo",
            "Kristian Francisco",
            "Mark Antonino",
            "Kirster Quinio",
            "Anton Wycoco",
            "Franz Paran",
            "Gil Canedo",
            "Ice Chavez"};

    private String[] message = {"has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",
            "has invited you to an event",};


    private int[] images = { R.drawable.movie01,
            R.drawable.movie02,
            R.drawable.movie03,
            R.drawable.movie04,
            R.drawable.movie05,
            R.drawable.movie06,
            R.drawable.movie07,
            R.drawable.movie08,
            R.drawable.movie09,
            R.drawable.movie10};

    @Override
    public NotificationRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationRecyclerView.ViewHolder holder, int position) {

        holder.notifImg.setImageResource(images[position]);
        holder.heading.setText(name[position] + " " + message[position]);
        holder.notifTypeImg.setImageResource(R.drawable.notification_chat);
    }

    @Override
    public int getItemCount() {
        return message.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView notifImg,notifTypeImg;
        TextView heading,notifTime;

        public ViewHolder(View itemView){
            super(itemView);
            notifImg = (ImageView) itemView.findViewById(R.id.notifImg);
            notifTypeImg = (ImageView) itemView.findViewById(R.id.notifTypeImg);
            heading = (TextView) itemView.findViewById(R.id.heading);
            notifTime = (TextView) itemView.findViewById(R.id.notifTime);
        }
    }
}
