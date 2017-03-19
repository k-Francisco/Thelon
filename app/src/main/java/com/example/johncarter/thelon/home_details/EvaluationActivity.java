package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.main_screens.LandingPage;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Acer on 04/12/2016.
 */

public class EvaluationActivity extends AppCompatActivity {

    RatingBar energyRating,passionRating,flexibilityRating,creativityRating;
    RatingBar teamPlayerRating,friendlinessRating,reliabilityRating,commitmentRating;
    String key;
    Firebase scoreTable;
    Firebase yourScoreTable;
    Float points;
    FirebaseUser firebaseUser;
    int a =0;
    String score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.volunteer_evaluation_layout);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        scoreTable = new Firebase("https://ethelon-33583.firebaseio.com/VolunteerScore");
        energyRating = (RatingBar) findViewById(R.id.rb1);
        passionRating = (RatingBar) findViewById(R.id.rb2);
        flexibilityRating = (RatingBar) findViewById(R.id.rb3);
        creativityRating = (RatingBar) findViewById(R.id.rb4);
        teamPlayerRating = (RatingBar) findViewById(R.id.rb5);
        friendlinessRating = (RatingBar) findViewById(R.id.rb6);
        reliabilityRating = (RatingBar) findViewById(R.id.rb7);
        commitmentRating = (RatingBar) findViewById(R.id.rb8);

        key = getIntent().getStringExtra("id");

        TextView finishBtn = (TextView) findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                points = (energyRating.getRating() * 10) +
                        (passionRating.getRating() * 10) +
                        (flexibilityRating.getRating() * 10) +
                        (creativityRating.getRating() * 10) +
                        (teamPlayerRating.getRating() * 10) +
                        (friendlinessRating.getRating() * 10) +
                        (reliabilityRating.getRating() * 10) +
                        (commitmentRating.getRating() * 10);
                scoreTable.child(key).child("score").setValue(points+"");
                if(a==1) {
                    finish();
                    startActivity(new Intent(EvaluationActivity.this, activity_volunteer_success.class).putExtra("score",score));
                }else{
                    Toast.makeText(EvaluationActivity.this, "Please wait a moment..You're still being evaluated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        yourScoreTable = new Firebase("https://ethelon-33583.firebaseio.com/VolunteerScore");
        Query query = yourScoreTable.child(firebaseUser.getUid());
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                 score = dataSnapshot.getValue().toString();
                 a = 1;
               // finish();
                //startActivity(new Intent(EvaluationActivity.this, activity_volunteer_success.class).putExtra("score",score));
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
       /* query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String score = dataSnapshot.getValue().toString();
                finish();
                startActivity(new Intent(EvaluationActivity.this, activity_volunteer_success.class).putExtra("score",score));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/


        Log.d("kobe","stars rating="+energyRating.getNumStars()+" getRatin g = "+energyRating.getNumStars());


        Toast.makeText(this, points+" score ", Toast.LENGTH_SHORT).show();

    }
}
