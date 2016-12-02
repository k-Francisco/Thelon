package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;

/**
 * Created by asus on 03/12/2016.
 */

public class ActivityList extends Fragment {
    FragmentManager fm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_home_actlist,container,false);
        TabLayout tab = (TabLayout)rootView.findViewById(R.id.tab_menu);
        tab.addTab(tab.newTab().setText("Activities"));
        tab.addTab(tab.newTab().setText("Volunteers"));
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.add_act);

        fm = getFragmentManager();
        fm.beginTransaction().add(new ActivitiesFragment(),"act_main").commit();
        fm.beginTransaction().replace(R.id.fram2,new ActivitiesFragment()).commit();
        fm.beginTransaction().add(new CreateActivityFragment(),"create_act").commit();
        //fm.beginTransaction().add(new VolunteersFragment(),"volunteers").commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    fm.beginTransaction().replace(R.id.fram2,new ActivitiesFragment()).addToBackStack("volunteers").commit();
                }
                else if(tab.getPosition() == 1){}
                //fm.beginTransaction().replace(R.id.fram2,new VolunteersFragment()).addToBackStack("act_main").commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fram2,new CreateActivityFragment()).addToBackStack("act_main").commit();
            }
        });

        return rootView;
    }
}
