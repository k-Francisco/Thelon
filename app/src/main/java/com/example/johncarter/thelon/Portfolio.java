package com.example.johncarter.thelon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Portfolio extends ActionBarActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        ButterKnife.bind(this);

        window = getWindow();
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_right);
        window.setEnterTransition(transition);
        window.setExitTransition(transition);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Portfolio");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
