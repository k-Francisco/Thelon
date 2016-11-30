package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class ActivityList_admin extends Fragment{

    FragmentManager fm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_home_actlist,container,false);
        TabLayout tab = (TabLayout)rootView.findViewById(R.id.tab_menu);
        tab.addTab(tab.newTab().setText("Manage Activity"));
        tab.addTab(tab.newTab().setText("Create Activity"));

        fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.fram2,new ActivitiesFragment()).commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    fm.beginTransaction().replace(R.id.fram2,new ActivitiesFragment()).commit();
                }
                else if(tab.getPosition() == 1)
                    fm.beginTransaction().replace(R.id.fram2,new CreateActivityFragment()).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }
}
