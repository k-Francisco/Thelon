package com.example.johncarter.thelon.Performance;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.johncarter.thelon.R;

public class Performance2 extends AppCompatActivity {

    Toolbar toolbar;
    ProgressBar progressBar1,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7,progressBar8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance2);

        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Performance");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        progressBar1 = (ProgressBar) findViewById(R.id.progress1);
        progressBar2 = (ProgressBar) findViewById(R.id.progress2);
        progressBar3 = (ProgressBar) findViewById(R.id.progress3);
        progressBar4 = (ProgressBar) findViewById(R.id.progress4);
        progressBar5 = (ProgressBar) findViewById(R.id.progress5);
        progressBar6 = (ProgressBar) findViewById(R.id.progress6);
        progressBar7 = (ProgressBar) findViewById(R.id.progress7);
        progressBar8 = (ProgressBar) findViewById(R.id.progress8);

        progressBar1.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar2.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar3.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar4.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar5.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar6.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar7.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);
        progressBar8.getProgressDrawable().setColorFilter(Color.parseColor("#483078"), PorterDuff.Mode.SRC_IN);

    }
}
