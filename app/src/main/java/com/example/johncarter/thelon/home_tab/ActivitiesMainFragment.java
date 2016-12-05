package com.example.johncarter.thelon.home_tab;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.home_details.home_details;
import com.qslll.library.ExpandingPagerFactory;
import com.qslll.library.fragments.ExpandingFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Acer on 05/12/2016.
 */

public class ActivitiesMainFragment extends Fragment implements ExpandingFragment.OnExpandingClickListener{

    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_home2,container,false);

        viewPager = (ViewPager)rootView.findViewById(R.id.viewPager);
        final TextView label = (TextView) rootView.findViewById(R.id.label);
        ActivitiesAdapter adapter = new ActivitiesAdapter(getFragmentManager());
        adapter.addAll(generateTravelList());
        viewPager.setAdapter(adapter);

        ExpandingPagerFactory.setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ExpandingFragment expandingFragment = ExpandingPagerFactory.getCurrentFragment(viewPager);
                if(expandingFragment != null && expandingFragment.isOpenend()){
                    expandingFragment.close();
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }

    private List<Travel> generateTravelList(){
        List<Travel> travels = new ArrayList<>();
        for(int i=0;i<5;++i){
            travels.add(new Travel("Feeding Program", R.drawable.feed1));
            travels.add(new Travel("Dental Mission", R.drawable.dental_mission));
            travels.add(new Travel("Tree Planting", R.drawable.tree_planting));
            travels.add(new Travel("Community Outreach", R.drawable.community_outreach));
            travels.add(new Travel("Disaster Relief", R.drawable.disaster_relief));
            travels.add(new Travel("Fun Run for a Cause", R.drawable.fun_run));
            travels.add(new Travel("Blood Donation", R.drawable.blood_donation));
            travels.add(new Travel("Blood Letting", R.drawable.blood_letting));
            travels.add(new Travel("Tuli Operation", R.drawable.libre_tuli));
            travels.add(new Travel("Sports Program", R.drawable.sports_campaign));
        }
        return travels;
    }

    @Override
    public void onExpandingClick(View view) {
        startActivity(new Intent(view.getContext(),home_details.class));
    }

}
