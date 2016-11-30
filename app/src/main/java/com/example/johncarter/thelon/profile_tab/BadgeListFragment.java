package com.example.johncarter.thelon.profile_tab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class BadgeListFragment extends Fragment{

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notification_list,container,false);

        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        listView.setLayoutManager(layoutManager);

        adapter = new BadgeListAdapter();
        listView.setAdapter(adapter);
        return rootView;
    }
}
