package com.example.johncarter.thelon.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Details_Text extends Fragment {


    public Home_Details_Text() {
        // Required empty public constructor
    }


    TextView textDetails;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home__details__text,container,false);
        textDetails = (TextView) rootView.findViewById(R.id.kobe);
        textDetails.setText("Time: 10:00 am \n" +
                "Date: December 10, 2016 \n" +
                "Location: USJ-R Basak Campus \n" +
                "for more info call 09257772302 \n" +
                "look for Anton Wycoco");
        return rootView;
    }

}
