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

public class DetailsContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.act_details_text,container,false);

        TextView details = (TextView)rootView.findViewById(R.id.kobe);
        details.setText("Contact Person: Anton Wycoco\n" +
                "Mobile Number: 09257772302\n" +
                "Email Address: antondakmats@yahoo.com\n");
        return rootView;
    }
}
