package com.example.johncarter.thelon.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.notification_tab.NotificationAdapter;
import com.example.johncarter.thelon.notification_tab.NotificationController;
import com.example.johncarter.thelon.notification_tab.NotificationRecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    FrameLayout fl;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notification_list,container,false);
        fl = (FrameLayout) rootView.findViewById(R.id.menu_frame);

        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        listView.setLayoutManager(layoutManager);

        adapter = new NotificationRecyclerView();
        listView.setAdapter(adapter);
        return rootView;
    }

}
