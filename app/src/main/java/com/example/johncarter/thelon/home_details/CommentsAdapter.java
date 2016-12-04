package com.example.johncarter.thelon.home_details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by Acer on 03/12/2016.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private int[] images = {R.drawable.charles,
            R.drawable.anton,
            R.drawable.kf,
            R.drawable.kobe};

    private String [] names = {"Charles Cruz", "Anton Wycoco", "Kristian Francisco", "Kobe Relativo"};

    private String [] comments = {"The event was fun. I felt so happy afterwards",
    "A very fulfilling experience!",
    "The feeling afterwards was so rewarding",
    "Nothing makes me happier than helping other people"};

    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.ViewHolder holder, int position) {
        holder.face.setImageResource(images[position]);
        holder.name.setText(names[position]);
        holder.comment.setText(comments[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView face;
        private TextView name, comment;

        public ViewHolder(View itemView) {
            super(itemView);
            face = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            comment = (TextView) itemView.findViewById(R.id.comment);
        }
    }
}
