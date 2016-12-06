package com.example.johncarter.thelon;

import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by john carter on 12/4/2016.
 */

public class DialogFragmentBadge extends DialogFragment {

    private int badgeImage[] = {R.drawable.ic_toothbadge,
            R.drawable.ic_greenthumb,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,
            R.drawable.ic_lock,};


    private String badgeTitle[] = {"Tooth Fairy",
            "Green Thumb",
            "Dirt Defiant",
            "Coral Chief",
            "Artisan Crafter",
            "Fixer Upper",
            "Eye Candy",
            "Socialite",
            "Foodie",
            "Nobel"};


    ImageView imageView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.badge_dialog,container,false);


        imageView = (ImageView) view.findViewById(R.id.dialogBadgeImg);
        textView = (TextView) view.findViewById(R.id.dialogBadgeTitle);
        int position = getArguments().getInt("position");
        imageView.setImageResource(badgeImage[position]);
        textView.setText(badgeTitle[position]);

        return view;
    }

}
