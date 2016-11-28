package com.example.johncarter.thelon.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.app.Fragment;
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


    FrameLayout fm;

    public LeaderBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_leader_board, container, false);
        fm = (FrameLayout) rootView.findViewById(R.id.menu_frame);
        ListView listView = (ListView) rootView.findViewById(R.id.leaderboard_listView);
        LeaderBoardController leaderBoardController = new LeaderBoardController();
        LeaderBoardAdapter leaderBoardAdapter = new LeaderBoardAdapter(rootView.getContext(), R.layout.leaderboard_list, leaderBoardController.getLeaderBoard());
        listView.setAdapter(leaderBoardAdapter);


        return rootView;


    }

}
