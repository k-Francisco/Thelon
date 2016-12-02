package com.example.johncarter.thelon.Performance;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class PerformanceRankFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rank_frag,container,false);
        return rootView;
    }
}
