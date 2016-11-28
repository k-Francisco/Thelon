package com.example.johncarter.thelon.main_screens;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.HomeFragment;
import com.example.johncarter.thelon.fragments.LeaderBoardFragment;
import com.example.johncarter.thelon.fragments.NotificationFragment;
import com.example.johncarter.thelon.fragments.UserProfileFragment;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class LandingPage extends AppCompatActivity implements BottomNavigation.OnMenuItemSelectionListener {

    BottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        bottomNavigation = (BottomNavigation) findViewById(R.id.BottomNavigation);
        bottomNavigation.setOnMenuItemClickListener(this);
        fragmentManager = getFragmentManager();
        window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.home));

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_frame, new HomeFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onMenuItemSelect(@IdRes int i, int i1, boolean b) {


        switch (i1){
            case 0:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                fragmentTransaction.replace(R.id.menu_frame, new HomeFragment(), "home");
                fragmentTransaction.commit();

                //window.setStatusBarColor(ContextCompat.getColor(this, R.color.home));

                break;
            case 1:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
                fragmentTransaction.replace(R.id.menu_frame, new NotificationFragment(), "notification");
                fragmentTransaction.commit();

                //window.setStatusBarColor(ContextCompat.getColor(this, R.color.leaderboard));
                break;

            case 2:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
                fragmentTransaction.replace(R.id.menu_frame, new LeaderBoardFragment(), "leaderboard");
                fragmentTransaction.commit();

               // window.setStatusBarColor(ContextCompat.getColor(this, R.color.leaderboard));
                break;
        }
    }



    @Override
    public void onMenuItemReselect(@IdRes int i, int i1, boolean b) {

    }



}
