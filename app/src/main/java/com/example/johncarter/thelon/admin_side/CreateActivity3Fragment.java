package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.content.Intent;
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

public class CreateActivity3Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.admin_create_activity3,container,false);
        TextView img = (TextView) rootView.findViewById(R.id.completeBtn) ;

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rootView.getContext(),CreateSuccess.class));
            }
        });
        return rootView;
    }
}
