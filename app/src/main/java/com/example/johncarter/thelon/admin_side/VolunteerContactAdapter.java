package com.example.johncarter.thelon.admin_side;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john carter on 12/3/2016.
 */

public class VolunteerContactAdapter extends RecyclerView.Adapter<VolunteerContactAdapter.ViewHolder> {

    View view1;

    private String[] names = {"Charles Cruz",
            "Tyler Lim",
            "Kobe Relativo",
            "Kristian Francisco",
            "Mark Antonino",
            "Kirster Quinio",
            "Anton Wycoco",
            "Franz Paran",
            "Gil Canedo",
            "Ice Chavez",
            "Gil Canedo",
            "Gil Canedo",
            "Gil Canedo",
            "Gil Canedo",
            "Gil Canedo"};

    private int[] images = {R.drawable.charles,
            R.drawable.tyler,
            R.drawable.kobe,
            R.drawable.kf,
            R.drawable.mark,
            R.drawable.kix,
            R.drawable.anton,
            R.drawable.fanz,
            R.drawable.gil,
            R.drawable.ice,
            R.drawable.gil,
            R.drawable.gil,
            R.drawable.gil,
            R.drawable.gil,
            R.drawable.gil};

    @Override
    public VolunteerContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_volunteer,parent,false);
        VolunteerContactAdapter.ViewHolder viewHolder = new VolunteerContactAdapter.ViewHolder(v);
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

    public int returnWhatIsSearched(Character firstLetter){
        int position = 0;
        boolean isFound = false;
//        Toast.makeText(view1.getContext(), firstLetter, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < names.length; i++){
            if(names[i].charAt(0) == firstLetter){
                position = i;
                isFound = true;
            }
            break;
        }
        if(isFound = false)
            position = -1;


        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private CircleImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            view1 = itemView;
            txtName = (TextView) itemView.findViewById(R.id.leader_name);
            img = (CircleImageView) itemView.findViewById(R.id.faceImg);

        }
    }


}
