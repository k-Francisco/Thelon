package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.models.Activity;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by dell on 12/1/2016.
 */

public class ActivitiesFragment extends Fragment{

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Firebase mroot;
    ArrayList<String> dates;
    ArrayList<String>acts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notification_list,container,false);

        dates = new ArrayList<>();
        acts = new ArrayList<>();
        mroot = new Firebase("https://ethelon-33583.firebaseio.com/Activity");
        mroot.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.exists()) {
                    Activity activity = dataSnapshot.getValue(Activity.class);
                    acts.add(activity.getName());
                    dates.add(activity.getDate());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        listView.setLayoutManager(layoutManager);

        adapter = new ActivityListAdapter(rootView.getContext(),acts,dates);
        listView.setAdapter(adapter);
        return rootView;
    }
}
