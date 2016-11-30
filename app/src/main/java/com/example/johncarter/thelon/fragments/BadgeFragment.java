package com.example.johncarter.thelon.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.johncarter.thelon.BadgeAdapter;
import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class BadgeFragment extends Fragment{

    FrameLayout fl;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public BadgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.badgeview_layout, container, false);
        fl = (FrameLayout) rootView.findViewById(R.id.frame1);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rec);
        layoutManager = new GridLayoutManager(rootView.getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new BadgeAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
