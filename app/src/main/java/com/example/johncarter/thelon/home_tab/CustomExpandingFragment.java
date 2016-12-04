package com.example.johncarter.thelon.home_tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.qslll.library.fragments.ExpandingFragment;

/**
 * Created by Acer on 05/12/2016.
 */

public class CustomExpandingFragment extends ExpandingFragment {

    static final String ARG_TRAVEL = "ARG_TRAVEL";
    Travel travel;

    public static CustomExpandingFragment newInstance(Travel travel){
        CustomExpandingFragment fragment = new CustomExpandingFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TRAVEL, travel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null) {
            travel = args.getParcelable(ARG_TRAVEL);
        }
    }

    @Override
    public Fragment getFragmentTop() {
        return FragmentTop.newInstance(travel);
    }

    @Override
    public Fragment getFragmentBottom() {
        return FragmentBottom.newInstance();
    }
}
