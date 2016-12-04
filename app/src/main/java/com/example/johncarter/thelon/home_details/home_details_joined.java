package com.example.johncarter.thelon.home_details;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.StaggeredAscPicsFragment;
import com.example.johncarter.thelon.admin_side.VolunteersInDetailsFragment;

/**
 * Created by Acer on 04/12/2016.
 */

public class home_details_joined extends AppCompatActivity{

    ImageView joinBtn,referBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_details_joined);

        joinBtn = (ImageView) findViewById(R.id.joinBtn);
        referBtn = (ImageView) findViewById(R.id.referBtn);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.volunteersFrame, new VolunteersInDetailsFragment()).commit();
        fm.beginTransaction().replace(R.id.ascPicsFrame, new StaggeredAscPicsFragment()).commit();
        fm.beginTransaction().replace(R.id.commentsFrame, new CommentsFragment()).commit();

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinBtn.setImageResource(R.drawable.ic_attendace_red);
                Snackbar.make(v, "Loading Attendance Scanner...",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(home_details_joined.this,AttendaceCheckinig.class));
                    }
                }, 2000);
            }
        });

        referBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                referBtn.setImageResource(R.drawable.ic_cancel_event_red);
                Snackbar.make(v, "Cancelling Event Participation",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 2000);
            }
        });

//        Slide slide = new Slide();
//        slide.setInterpolator(new DecelerateInterpolator());
//        slide.addTarget(R.id.actTitle);
//        slide.addTarget(R.id.hostpic);
//        slide.addTarget(R.id.ratingBar);
//        slide.addTarget(R.id.tab_menu);
//        getWindow().setEnterTransition(slide);
//        getWindow().setExitTransition(slide);
    }
}

