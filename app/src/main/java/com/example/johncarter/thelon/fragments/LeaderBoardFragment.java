package com.example.johncarter.thelon.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.leaderboard_tab.LeaderBoardAdapter;
import com.example.johncarter.thelon.leaderboard_tab.LeaderBoardController;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderBoardFragment extends Fragment {


    FrameLayout fl;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.leaderboard_layout, container, false);
        fl = (FrameLayout) rootView.findViewById(R.id.frame1);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LeaderBoardAdapter();
        recyclerView.setAdapter(adapter);
        return rootView;
    }




}
