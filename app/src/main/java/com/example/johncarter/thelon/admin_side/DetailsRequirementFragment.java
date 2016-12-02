package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by asus on 03/12/2016.
 */

public class DetailsRequirementFragment extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.act_details_text,container,false);

            TextView details = (TextView)rootView.findViewById(R.id.kobe);
            details.setText("People from: Cebu City Area\n" +
                    "Age: 20+ yrs. old\n" +
                    "Gender: M/F\n" +
                    "Occupation");
            return rootView;
        }
}
