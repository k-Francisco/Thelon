package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.main_screens.LandingPage;

/**
 * Created by Acer on 04/12/2016.
 */

public class EvaluationActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.volunteer_evaluation_layout);

        TextView finishBtn = (TextView) findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(EvaluationActivity.this, LandingPage.class));
            }
        });
    }
}
