package com.example.johncarter.thelon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.johncarter.thelon.main_screens.LandingPage;

public class interest_skills extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_skills);

        ImageView imageView1 = (ImageView) findViewById(R.id.ivBefriend);
        ImageView imageView2 = (ImageView) findViewById(R.id.ivOffice);
        ImageView imageView3 = (ImageView) findViewById(R.id.ivArts);
        ImageView imageView4 = (ImageView) findViewById(R.id.ivTeaching);
        ImageView imageView5 = (ImageView) findViewById(R.id.ivYouth);
        ImageView imageView6 = (ImageView) findViewById(R.id.ivUndecided);

        LinearLayout mFirst = (LinearLayout) findViewById(R.id.llAct1);
        LinearLayout mSecond = (LinearLayout) findViewById(R.id.llAct2);
        LinearLayout mThird = (LinearLayout) findViewById(R.id.llAct3);
        LinearLayout mFourth = (LinearLayout) findViewById(R.id.llAct4);
        LinearLayout mFifth = (LinearLayout) findViewById(R.id.llAct5);
        LinearLayout mSixth = (LinearLayout) findViewById(R.id.llAct6);

        mFirst.setOnClickListener(this);
        mSecond.setOnClickListener(this);
        mThird.setOnClickListener(this);
        mFourth.setOnClickListener(this);
        mFifth.setOnClickListener(this);
        mSixth.setOnClickListener(this);

//        imageView1.setOnClickListener(this);
//        imageView2.setOnClickListener(this);
//        imageView3.setOnClickListener(this);
//        imageView4.setOnClickListener(this);
//        imageView5.setOnClickListener(this);
//        imageView6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, LandingPage.class);
        startActivity(intent);
        finish();
    }
}
