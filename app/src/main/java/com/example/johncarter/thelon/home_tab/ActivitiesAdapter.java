package com.example.johncarter.thelon.home_tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.qslll.library.ExpandingViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 05/12/2016.
 */

public class ActivitiesAdapter extends ExpandingViewPagerAdapter {

    List<Travel> travels;

    public ActivitiesAdapter(FragmentManager fm) {
        super(fm);
        travels = new ArrayList<>();
    }

    public void addAll(List<Travel> travels){
        this.travels.addAll(travels);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Travel travel = travels.get(position);
        return CustomExpandingFragment.newInstance(travel);
    }

    @Override
    public int getCount() {
        return travels.size();
    }
}
