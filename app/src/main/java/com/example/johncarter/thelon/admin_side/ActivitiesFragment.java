package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.models.Activity;
import com.example.johncarter.thelon.models.Url;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import com.firebase.client.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;
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
    ArrayList<StorageReference>photo;
    StorageReference storageReference;

    Firebase ActivityPhotos;
    int i = 0;
    Query mref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.notification_list,container,false);
        Firebase.setAndroidContext(getActivity());
        photo = new ArrayList<>();
        storageReference = FirebaseStorage.getInstance().getReference();
        ActivityPhotos = new Firebase("https://ethelon-33583.firebaseio.com/ActivityPhotos");
        mroot = new Firebase("https://ethelon-33583.firebaseio.com/Activity");
        dates = new ArrayList<>();
        acts = new ArrayList<>();


        mroot.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.exists()) {
//                    Toast.makeText(getActivity(), "NAAY SUD ANG mROOT", Toast.LENGTH_SHORT).show();
                    Activity activity = dataSnapshot.getValue(Activity.class);
                    acts.add(activity.getName());
                    dates.add(activity.getDate());
                    //mref = ActivityPhotos' Table reference
                    mref = ActivityPhotos.child(dataSnapshot.getKey()).orderByChild("Url");
                    Log.e("key",""+dataSnapshot.getKey());
                    Log.e("key",""+mref.toString());
                    final String is = dataSnapshot.getKey();

                    mref.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            Url url = dataSnapshot.getValue(Url.class);

                                if (photo.size() == dates.size()) {
                                    Log.e("anton", "Photo size =" + photo.size() + " FirebaseCount = " + dataSnapshot.getChildrenCount() + "" + url.getUrl() );

                                    //i++;
                                } else {
                                    StorageReference mrefs  = storageReference.child(is).child(dataSnapshot.getKey()).child(url.getUrl());
                                    photo.add(mrefs);
                                    Log.e("anton", "inigAddNahPhoto size =" + photo.size() + " FirebaseCount = " + dataSnapshot.getChildrenCount() + "" + url.getUrl()+ " key = "+is+"  "+dates.size());
                                    if(photo.size() == dates.size()){
                                        start(rootView);
                                    }
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

                }else{
                    Toast.makeText(getActivity(), "WALAY SUD", Toast.LENGTH_SHORT).show();
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



        return rootView;
    }
    public void start(View rootView){
        RecyclerView listView = (RecyclerView) rootView.findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        listView.setLayoutManager(layoutManager);

       // Log.e("anton", "PHOTO SIZE = " + photo.size());

        adapter = new ActivityListAdapter(rootView.getContext(), acts, dates, photo);
        listView.setAdapter(adapter);
        i++;

    }
}
