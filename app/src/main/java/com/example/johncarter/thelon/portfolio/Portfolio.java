package com.example.johncarter.thelon.portfolio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;

import com.example.johncarter.thelon.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Portfolio extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

    }
}
