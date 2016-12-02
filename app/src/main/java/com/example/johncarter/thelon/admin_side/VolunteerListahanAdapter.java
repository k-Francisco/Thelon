package com.example.johncarter.thelon.admin_side;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus on 03/12/2016.
 */

public class VolunteerListahanAdapter extends RecyclerView.Adapter<VolunteerListahanAdapter.ViewHolder > {

    private int[] images;

    private ArrayList<Integer> lista;

    public VolunteerListahanAdapter(ArrayList<Integer> lista){
        this.lista = lista;
    }

    @Override
    public VolunteerListahanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.volunteer_face_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VolunteerListahanAdapter.ViewHolder holder, int position) {
        holder.civ.setImageResource(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView civ;

        public ViewHolder(View itemView) {
            super(itemView);
            civ = (CircleImageView)itemView.findViewById(R.id.faceImg);
        }
    }
}
