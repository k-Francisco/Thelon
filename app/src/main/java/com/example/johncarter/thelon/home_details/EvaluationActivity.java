package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.main_screens.LandingPage;

/**
 * Created by Acer on 04/12/2016.
 */

public class EvaluationActivity extends AppCompatActivity {

    RatingBar energyRating,passionRating,flexibilityRating,creativityRating;
    RatingBar teamPlayerRating,friendlinessRating,reliabilityRating,commitmentRating;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.volunteer_evaluation_layout);

        energyRating = (RatingBar) findViewById(R.id.rb1);
        passionRating = (RatingBar) findViewById(R.id.rb2);
        flexibilityRating = (RatingBar) findViewById(R.id.rb3);
        creativityRating = (RatingBar) findViewById(R.id.rb4);
        teamPlayerRating = (RatingBar) findViewById(R.id.rb5);
        friendlinessRating = (RatingBar) findViewById(R.id.rb6);
        reliabilityRating = (RatingBar) findViewById(R.id.rb7);
        commitmentRating = (RatingBar) findViewById(R.id.rb8);

        TextView finishBtn = (TextView) findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(EvaluationActivity.this, LandingPage.class));
            }
        });

        float points = (energyRating.getRating() * 10) +
                    (passionRating.getRating() * 10) +
                    (flexibilityRating.getRating() * 10) +
                    (creativityRating.getRating() * 10) +
                    (teamPlayerRating.getRating() * 10) +
                    (friendlinessRating.getRating() * 10) +
                    (reliabilityRating.getRating() * 10) +
                    (commitmentRating.getRating() * 10);
    }
}
