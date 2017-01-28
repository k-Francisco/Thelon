package com.example.johncarter.thelon.profile_tab;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.johncarter.thelon.Performance.Performance2;
import com.example.johncarter.thelon.Performance.PerformanceFragment;
import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.NotificationFragment;
import com.example.johncarter.thelon.portfolio.PorfolioNew;
import com.example.johncarter.thelon.portfolio.Portfolio;

public class ProfileActivity extends    AppCompatActivity implements View.OnClickListener {

    private ImageView portfolio, performance;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_profile);

        portfolio = (ImageView) findViewById(R.id.portfolio_icon);
        portfolio.setOnClickListener(this);

        performance = (ImageView) findViewById(R.id.performance_icon);
        performance.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackground(null);
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.portfolio_icon:
                intent = new Intent(ProfileActivity.this, PorfolioNew.class);
                startActivity(intent);
                break;

            case R.id.performance_icon:
                intent = new Intent(ProfileActivity.this, Performance2.class);
                startActivity(intent);
                break;
        }

    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
