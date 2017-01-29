package com.example.johncarter.thelon.home_tab;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.home_details.home_details;
import com.example.johncarter.thelon.models.Activity;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.qslll.library.ExpandingPagerFactory;
import com.qslll.library.fragments.ExpandingFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Acer on 05/12/2016.
 */

public class ActivitiesMainFragment extends Fragment implements ExpandingFragment.OnExpandingClickListener{

    Firebase mrootAct;
    ViewPager viewPager;
    Activity activity;
    List<Travel> travels;
    ActivitiesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_home2,container,false);

        mrootAct = new Firebase("https://ethelon-33583.firebaseio.com/Activity");
        viewPager = (ViewPager)rootView.findViewById(R.id.viewPager);
        final TextView label = (TextView) rootView.findViewById(R.id.label);
        travels = new ArrayList<>();
        adapter  = new ActivitiesAdapter(getFragmentManager());
        /*adapter.addAll(generateTravelList());
        viewPager.setAdapter(adapter);
*/


        mrootAct.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.exists()) {
                    activity = dataSnapshot.getValue(Activity.class);
                    //Toast.makeText(getActivity(), "asdasdasdasds! = "+activity.getName(), Toast.LENGTH_LONG).show();
                    travels.add(new Travel(activity.getName(), R.drawable.feed1));
                    Log.e("kobe",""+travels.size()+" "+activity.getName()+ "Travels size"+travels.size());

                    adapter.addAll(travels);
                    viewPager.setAdapter(adapter);


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

        ExpandingPagerFactory.setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ExpandingFragment expandingFragment = ExpandingPagerFactory.getCurrentFragment(viewPager);
                if(expandingFragment != null && expandingFragment.isOpenend()){
                    expandingFragment.close();
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }

    private List<Travel> generateTravelList(){


      //  travels.add(new Travel("Feeding Program", R.drawable.feed1));
        //    travels.add(new Travel("Dental Mission", R.drawable.dental_mission));

        mrootAct.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.exists()) {
                    activity = dataSnapshot.getValue(Activity.class);
                    //Toast.makeText(getActivity(), "asdasdasdasds! = "+activity.getName(), Toast.LENGTH_LONG).show();
                    travels.add(new Travel("Pisteng  yawa"+activity.getName(), R.drawable.feed1));
                //    Log.e("kobe",""+travels.size());
                    adapter.notifyDataSetChanged();

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
        //Log.e("kobe",""+travels.size());
        return travels;
    }

    @Override
    public void onExpandingClick(View view) {
        startActivity(new Intent(view.getContext(),home_details.class));
    }

}
