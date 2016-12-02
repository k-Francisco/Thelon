package com.example.johncarter.thelon.main_screens;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;

import com.example.johncarter.thelon.R;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.shmakinv.android.material.widget.GpCollapsingToolbar;

public class Settings extends ActionBarActivity {

    @Bind(R.id.nav_toolbar)
    Toolbar toolbar;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);


        window = getWindow();
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_right);
        window.setEnterTransition(transition);
        window.setExitTransition(transition);

        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
