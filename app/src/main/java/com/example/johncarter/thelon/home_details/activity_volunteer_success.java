package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.main_screens.LandingPage;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_volunteer_success extends AppCompatActivity {
    RelativeLayout outer_layout_container;
    TextView activity_points,activity_finish_btn;
    ProgressBar loadingPoints;
    Firebase scoreTable;
    Query query;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_success);
        outer_layout_container = (RelativeLayout) findViewById(R.id.outer_layout_container);
        activity_points = (TextView) findViewById(R.id.activity_points);
        activity_finish_btn = (TextView) findViewById(R.id.activity_finish_btn);
        loadingPoints = (ProgressBar) findViewById(R.id.loadingPoints);
        scoreTable = new Firebase("https://ethelon-33583.firebaseio.com/VolunteerScore");
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
       /* query = scoreTable.child(firebaseUser.getUid()).child("score");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String score = dataSnapshot.getValue().toString();

                float final_score = Float.parseFloat(score);
                activity_points.setText(Math.round(final_score) + "");
                loadingPoints.setVisibility(View.GONE);
                outer_layout_container.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/

        String score = getIntent().getStringExtra("score");
        float final_score = Float.parseFloat(score);
        activity_points.setText(Math.round(final_score) + "");
        loadingPoints.setVisibility(View.GONE);
        outer_layout_container.setVisibility(View.VISIBLE);

        activity_finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_volunteer_success.this, LandingPage.class));
            }
        });

    }
}
