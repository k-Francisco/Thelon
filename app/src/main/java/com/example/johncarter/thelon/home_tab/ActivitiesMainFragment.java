package com.example.johncarter.thelon.home_tab;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.example.johncarter.thelon.models.Url;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.qslll.library.ExpandingPagerFactory;
import com.qslll.library.fragments.ExpandingFragment;

import java.lang.reflect.Type;
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
    StorageReference storageReference;
    List<Activity> activityList;
    Query query;
    List<Url> uri = new ArrayList<>();
    Firebase ActivityPhotos;
    Activity act;
    int pos;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_home2,container,false);

        activityList = new ArrayList<>();
        ActivityPhotos = new Firebase("https://ethelon-33583.firebaseio.com/ActivityPhotos");

        storageReference = FirebaseStorage.getInstance().getReference();
        viewPager = (ViewPager)rootView.findViewById(R.id.viewPager);
        final TextView label = (TextView) rootView.findViewById(R.id.label);
        travels = new ArrayList<>();

        adapter  = new ActivitiesAdapter(getFragmentManager());
        /*adapter.addAll(generateTravelList());
        viewPager.setAdapter(adapter);
*/

        mrootAct = new Firebase("https://ethelon-33583.firebaseio.com/Activity");

        mrootAct.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.exists()) {
                    activity = dataSnapshot.getValue(Activity.class);
                    activityList.add(activity);

                    query = ActivityPhotos.child(dataSnapshot.getKey()).orderByChild("url");
                    final String is = dataSnapshot.getKey();

                    query.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            Url url = dataSnapshot.getValue(Url.class);
                            uri.add(url);
                            StorageReference st = storageReference.child("ActivityPhotos").child(is).child(url.getUrl());
                            travels.add(new Travel(activity.getActname(), st));
                           Log.e("dd",""+activity.getActname());
                            adapter.addAll(travels);
                            viewPager.setAdapter(adapter);
                          //  Log.e("Anton",activityList.get(pos).getDate()+" at "+activityList.get(pos).getTime()+ "activityList size"
                            //+activityList.size());
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
                    pos = position;
                }
            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                Log.e("Anton","POSI "+pos);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
             //   Log.e("Anton","POSI "+state);
            }
        });

        return rootView;
    }

    @Override
    public void onExpandingClick(View view) {


        Intent intent = new Intent(getContext(),home_details.class);
        intent.putExtra("dateAndtime",activityList.get(pos).getActDate()+" at "+activityList.get(pos).getActTime());
        intent.putExtra("location",activityList.get(pos).getvLocation());
        intent.putExtra("occupation",activityList.get(pos).getvOccupation());
        intent.putExtra("contactNumberAndPerson",activityList.get(pos).getPcontactNumber()+" / "+activityList.get(pos).getPpersonInCharge());
        intent.putExtra("photo", (Parcelable) travels.get(pos).getImage());

        Log.e("nelson",activityList.get(pos).getActFoundationCreator()+" at "+activityList.get(pos).getActname());
       startActivity(intent);
    }

    public int getPageSelected(){
        return pos;
    }

    public Intent returnIntent(Intent intent, int pos){
        intent.putExtra("dateAndtime",activityList.get(pos).getActDate()+" at "+activityList.get(pos).getActTime());
        intent.putExtra("location",activityList.get(pos).getvLocation());
        Log.e("anton",""+activityList.get(pos).getvLocation());
        intent.putExtra("occupation",activityList.get(pos).getvOccupation());
        intent.putExtra("foundation",activityList.get(pos).getActFoundationCreator());
        intent.putExtra("name",travels.get(pos).getName());
        intent.putExtra("contactNumberAndPerson",activityList.get(pos).getPcontactNumber()+" / "+activityList.get(pos).getPpersonInCharge());
        intent.putExtra("photo", uri.get(pos).getUrl());
        intent.putExtra("key",activityList.get(pos).getKey());

        return intent;
    }

}
