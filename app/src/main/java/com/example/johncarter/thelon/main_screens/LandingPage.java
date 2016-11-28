package com.example.johncarter.thelon.main_screens;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.HomeFragment;
import com.example.johncarter.thelon.fragments.LeaderBoardFragment;
import com.example.johncarter.thelon.fragments.NotificationFragment;
import com.example.johncarter.thelon.fragments.UserProfileFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

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
        //window.setStatusBarColor(ContextCompat.getColor(this, R.color.home));


        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Settings").withIcon(R.drawable.ic_heart)
                .withSubItems(new SecondaryDrawerItem().withName("sub item"));
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Edit Profile");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Log out");

        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.home_backpic)
                .addProfiles(
                        new ProfileDrawerItem().withName("Kristian Francisco")
                                .withEmail("piattosnovalays@gmail.com")
                                .withIcon(getResources().getDrawable(R.drawable.profile_pic))
                )
                .build();


        Drawer drawer = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withActivity(this)
                .addDrawerItems(
                        item1,
                        item2,
                        item3

                )
                .addStickyDrawerItems(new PrimaryDrawerItem().withName("I dont know"))
                .buildForFragment();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_frame, new HomeFragment());
        fragmentTransaction.commit();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_home));

    }

    @Override
    public void onMenuItemSelect(@IdRes int i, int i1, boolean b) {


        switch (i1){
            case 0:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                fragmentTransaction.replace(R.id.menu_frame, new HomeFragment(), "home");
                fragmentTransaction.commit();

                window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_home));

                break;
            case 1:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
                fragmentTransaction.replace(R.id.menu_frame, new NotificationFragment(), "notification");
                fragmentTransaction.commit();

                window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_notification));
                break;

            case 2:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
                fragmentTransaction.replace(R.id.menu_frame, new LeaderBoardFragment(), "leaderboard");
                fragmentTransaction.commit();

                window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_leaderboard));
                break;
        }
    }



    @Override
    public void onMenuItemReselect(@IdRes int i, int i1, boolean b) {

    }



}
