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

public class DetailsOverviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.act_details_text,container,false);

        TextView details = (TextView)rootView.findViewById(R.id.kobe);
        details.setText("Activity: Feeding Program\n" +
                "Location: Bayanihan Subdivision, Basak Pardo\n" +
                "Street: 4th Street\n" +
                "City/Town: Cebu\n" +
                "Date: Jan. 10, 2016\n" +
                "Time: 4:00pm");
        return rootView;
    }
}
