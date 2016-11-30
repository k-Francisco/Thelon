package com.example.johncarter.thelon.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.BadgeAdapter;
import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class BadgeDetailsFragment extends Fragment{

    private String[] names = {"Tooth-fairy",
            "Green thumb",
            "Dirt defiant",
            "Coral chief",
            "Artisan crafter",
            "Fixer upper",
            "Eye-candy",
            "Socialite",
            "Foodie",
            "Nobel"};

    private int[] images = {R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black,
            R.drawable.black
    };

    private String[] des = {"Join 1 dental activity.",
            "N/A",
            "N/A",
            "N/A",
            "N/A",
            "N/A",
            "N/A",
            "N/A",
            "N/A",
            "N/A"};

    ImageView img;
    TextView txt1,txt2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.badge_details_layout,container,false);

        img = (ImageView) rootView.findViewById(R.id.badgeImage);
        txt1 = (TextView) rootView.findViewById(R.id.badgeName);
        txt2 = (TextView) rootView.findViewById(R.id.badgeDesc);

        int position = getArguments().getInt("position");

        img.setImageResource(images[position]);
        txt1.setText(names[position]);
        txt2.setText(des[position]);

        return rootView;
    }
}
