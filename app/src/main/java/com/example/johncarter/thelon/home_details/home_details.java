package com.example.johncarter.thelon.home_details;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.Home_Details_Text;

import butterknife.ButterKnife;

public class home_details extends AppCompatActivity {

    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_details);

//        Slide slide = new Slide();
//        slide.setInterpolator(new DecelerateInterpolator());
//        slide.addTarget(R.id.actTitle);
//        slide.addTarget(R.id.hostpic);
//        slide.addTarget(R.id.ratingBar);
//        slide.addTarget(R.id.tab_menu);
//        getWindow().setEnterTransition(slide);
//        getWindow().setExitTransition(slide);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_menu);
        tab.addTab(tab.newTab().setText("Details"));
        tab.addTab(tab.newTab().setText("Pictures"));
        tab.addTab(tab.newTab().setText("Similar Activities"));

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.tab_frame,new Home_Details_Text()).commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.tab_frame, new Home_Details_Text()).commit();
                } else if (tab.getPosition() == 1) {
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.tab_frame, new StaggeredFragment()).commit();
                } else if (tab.getPosition() == 2) {
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.tab_frame, new HorizontalFragment()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        TextView details = (TextView) findViewById(R.id.details);
//        details.setText("Time: 10:00 am \n" +
//                "Date: December 10, 2016 \n" +
//                "Location: USJ-R Basak Campus \n" +
//                "for more info call 09257772302 \n" +
//                "look for Anton Wycoco");
//
//        FragmentManager fm = getFragmentManager();
//        fm.beginTransaction().replace(R.id.shit, new PracticeFragment()).commit();
//        fm.beginTransaction().replace(R.id.shit2, new PracticeFragment2()).commit();
    }
}
