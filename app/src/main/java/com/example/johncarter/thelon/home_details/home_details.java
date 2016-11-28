package com.example.johncarter.thelon.home_details;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

public class home_details extends AppCompatActivity {

    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_details);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        rb.setNumStars(5);
        rb.setRating(Float.parseFloat("4"));

        TextView details = (TextView) findViewById(R.id.details);
        details.setText("Time: 10:00 am \n" +
                "Date: December 10, 2016 \n" +
                "Location: USJ-R Basak Campus \n" +
                "for more info call 09257772302 \n" +
                "look for Anton Wycoco");

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.shit, new StaggeredFragment()).commit();
        fm.beginTransaction().replace(R.id.shit2, new HorizontalFragment()).commit();
    }
}
