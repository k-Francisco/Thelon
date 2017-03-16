package com.example.johncarter.thelon.portfolio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.home_details.AttendaceCheckinig;
import com.example.johncarter.thelon.models.Activity;
import com.example.johncarter.thelon.models.PortfolioActivity;
import com.example.johncarter.thelon.models.Url;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.ramotion.foldingcell.FoldingCell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 28/01/2017.
 */

public class PorfolioNew extends AppCompatActivity {

    Firebase activitiesJoinedBeforeDate;
    Query query;
    Query queryPhoto;
    FirebaseAuth auth;
    Activity activityModel;
    PorfolioNewAdapter adapter;
    ListView theListView;
    StorageReference storageReference, getphoto;
    int count2 = 0;
    int count3 = 0;
    Firebase activityPhotos;
    PortfolioActivity portfolioActivity;
    ArrayList<StorageReference>sList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_listview);
        Firebase.setAndroidContext(this);

//        Window window = this.getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.setStatusBarColor(Color.parseColor("#EE2A1B"));

        auth = FirebaseAuth.getInstance();
        activitiesJoinedBeforeDate = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesBefore");
        activityPhotos = new Firebase("https://ethelon-33583.firebaseio.com/ActivityPhotos");
         storageReference = FirebaseStorage.getInstance().getReference();

        sList = new ArrayList<>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Portfolio");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setBackgroundColor(Color.parseColor("#EE2A1B"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final int counter = 0;

        String userID = auth.getCurrentUser().getUid();
        final ArrayList<PortfolioActivity> items = new ArrayList<PortfolioActivity>();

         theListView = (ListView) findViewById(R.id.mainListView);
        query = activitiesJoinedBeforeDate.orderByChild(userID);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            final String activityJoinedKey = dataSnapshot.getKey();
                Log.e("joe"," key "+activityJoinedKey);
                final Firebase activity = new Firebase("https://ethelon-33583.firebaseio.com/Activity");
                Query activitiesJoined = activity.orderByKey().equalTo(activityJoinedKey);
                final int count = (int) dataSnapshot.getChildrenCount();


                activitiesJoined.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    activityModel = dataSnapshot.getValue(Activity.class);
                        Log.e("jaz","key sud sa joined "+activityModel.getKey());

                        queryPhoto = activityPhotos.child(dataSnapshot.getKey()).orderByChild("Url");
                        final String key = dataSnapshot.getKey();
                        queryPhoto.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                Url url = dataSnapshot.getValue(Url.class);
                                getphoto = storageReference.child("ActivityPhotos").child(key)
                                        .child(url.getUrl());
                                sList.add(getphoto);
                                Log.e("rose","photo "+sList.size());


                                if(items.size() == sList.size()){
                                    for(int a = 0; a < count2; a++){
                                        items.get(a).setImage(sList.get(a));
                                        Log.e("joe","ni count kay = "+a);
                                    }
                                    start(items);
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



                        portfolioActivity = new PortfolioActivity(R.drawable.anton, activityModel.getActDate()
                                , activityModel.getActTime(), activityModel.getActname(), activityModel.getActFoundationCreator(), "1", "2", "0",
                                activityModel.getPcontactNumber(), activityModel.getPpersonInCharge(), activityModel.getActCity()
                                , activityModel.getActStreet(), getphoto,2);
                        items.add(portfolioActivity);
                        count2++;
                        /*Log.e("joe","count sa pag add"+count2);
                        Log.e("joe","count niya = "+count);
                        Log.e("kobe","count sa photo= "+sList.size());*/

                        if(count == count2 && sList.size() == count){
                            for(int a = 0; a < count2; a++){
                                items.get(a).setImage(sList.get(a));
                                Log.e("joe","ni count kay = "+a);
                            }
                            start(items);
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


        //final ArrayList<PortfolioActivity> items = PortfolioActivity.getTestingList();







    }

    public void start(ArrayList<PortfolioActivity> items){
        adapter = new PorfolioNewAdapter(this,items);
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PorfolioNew.this,AttendaceCheckinig.class));
            }
        });

        theListView.setAdapter(adapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });
        Log.e("joe","nisud sa start");
    }
}
