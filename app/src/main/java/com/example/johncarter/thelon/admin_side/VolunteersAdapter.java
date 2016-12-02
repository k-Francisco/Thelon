package com.example.johncarter.thelon.admin_side;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus on 03/12/2016.
 */

public class VolunteersAdapter extends RecyclerView.Adapter<VolunteersAdapter.ViewHolder> {

    ArrayList<Integer> arr = new ArrayList<>();
    View charles;

    public VolunteersAdapter(View charles){
        this.charles = charles;
    }

    private String[] names = {"Charles Cruz",
            "Tyler Lim",
            "Kobe Relativo",
            "Kristian Francisco",
            "Mark Antonino",
            "Kirster Quinio",
            "Anton Wycoco",
            "Franz Paran",
            "Gil Canedo",
            "Ice Chavez"};

    private int[] images = {R.drawable.charles,
            R.drawable.tyler,
            R.drawable.kobe,
            R.drawable.kf,
            R.drawable.mark,
            R.drawable.kix,
            R.drawable.anton,
            R.drawable.fanz,
            R.drawable.gil,
            R.drawable.ice};


    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private CircleImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.leader_name);
            img = (CircleImageView) itemView.findViewById(R.id.faceImg);
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecyclerView recyclerView = (RecyclerView)charles.findViewById(R.id.recyclerView);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(charles.getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    arr.add(images[getAdapterPosition()]);
                    RecyclerView.Adapter adapter = new VolunteerListahanAdapter(arr);
                    recyclerView.setAdapter(adapter);
                    StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                    recyclerView.setLayoutManager(sgm);
                }
            });
        }
    }



    @Override
    public VolunteersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_volunteer,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(names[position]);
        holder.img.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}
