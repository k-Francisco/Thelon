package com.example.johncarter.thelon.home_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.johncarter.thelon.R;

/**
 * Created by Acer on 04/12/2016.
 */

public class EvaluationActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.volunteer_evaluation_layout);
    }
}
