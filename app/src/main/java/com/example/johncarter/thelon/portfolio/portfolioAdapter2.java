package com.example.johncarter.thelon.portfolio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.VolunteerContactAdapter;

/**
 * Created by john carter on 12/4/2016.
 */

public class portfolioAdapter2 extends RecyclerView.Adapter<portfolioAdapter2.ViewHolder> {



    private String[] title = {"Charles Cruz",
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

    private int status[] = {R.drawable.ic_bookmark_upcoming,
            R.drawable.ic_bookmark_upcoming,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp,};

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

    private String[] desc = {"This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things",
            "This feeding program reminds me of that kid that inspired me a lot to do good things"};





    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_layout,parent,false);
        portfolioAdapter2.ViewHolder viewHolder = new portfolioAdapter2.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(title[position]);
        holder.desc.setText(desc[position]);
        holder.pic.setImageResource(images[position]);
        holder.status.setImageResource(status[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, desc;
        private ImageView pic, status;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.portfolio_card_title);
            desc = (TextView) itemView.findViewById(R.id.portfolio_card_desc);
            pic = (ImageView) itemView.findViewById(R.id.portfolio_card_image);
            status = (ImageView) itemView.findViewById(R.id.portfolio_card_status);

        }
    }
}
