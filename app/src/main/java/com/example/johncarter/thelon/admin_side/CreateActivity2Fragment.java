package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.johncarter.thelon.R;

/**
 * Created by asus on 03/12/2016.
 */

public class CreateActivity2Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_create_activity2,container,false);
        FragmentManager fm = getFragmentManager();
        FrameLayout step3 = (FrameLayout) rootView.findViewById(R.id.step3);

        VolunteersFragment vm = new VolunteersFragment();
        vm.setViewzz(rootView);
        fm.beginTransaction().replace(R.id.rec_vol_frame,vm).commit();

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fram2,new CreateActivity3Fragment()).addToBackStack("step2").commit();
            }
        });

        return rootView;
    }
}
