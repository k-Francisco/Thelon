package com.example.johncarter.thelon.admin_side;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;
import com.gjiazhe.wavesidebar.WaveSideBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminVolunteer extends Fragment {

    WaveSideBar sideBar;
    public AdminVolunteer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_admin_volunteer,container,false);


        sideBar = (WaveSideBar) rootview.findViewById(R.id.side_bar);
        sideBar.setPosition(WaveSideBar.POSITION_RIGHT);
        sideBar.setTextColor(Color.BLACK);
        sideBar.setLazyRespond(true);
        sideBar.setMaxOffset(100);
        sideBar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        sideBar.setIndexItems("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {

            }
        });

        return rootview;
    }

}
