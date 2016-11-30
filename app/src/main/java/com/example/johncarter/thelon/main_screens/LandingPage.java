package com.example.johncarter.thelon.main_screens;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.HomeFragment;
import com.example.johncarter.thelon.fragments.LeaderBoardFragment;
import com.example.johncarter.thelon.fragments.NotificationFragment;
import com.example.johncarter.thelon.fragments.UserProfileFragment;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import butterknife.ButterKnife;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class LandingPage extends AppCompatActivity implements BottomNavigation.OnMenuItemSelectionListener {

    PrimaryDrawerItem home, portfolio, badges, editProfile, settings, logOut, helpAndFeedback, reportBug, aboutEthelon;
    AccountHeader accountHeader;
    BottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        ButterKnife.bind(this);

        //Initializes bottom bar and onclick listener
        bottomNavigation = (BottomNavigation) findViewById(R.id.BottomNavigation);
        bottomNavigation.setOnMenuItemClickListener(this);

        //Initializes window
        window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        //sets the first screen on the home fragment and sets the status bar color the same as the bottom bar color
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_frame, new HomeFragment());
        fragmentTransaction.commit();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_home));



        //Initializes drawer items
        initNavDrawerItems();

        //Initializes drawer profile
        initNavDrawerProfile();

        //creates the navigation drawer with the profile and items
        Drawer drawer = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withActivity(this)
                .addDrawerItems(
                        home,
                        portfolio,
                        badges,
                        editProfile,
                        settings,
                        logOut,
                        new DividerDrawerItem(),
                        helpAndFeedback,
                        reportBug,
                        aboutEthelon

                )
                .withSelectedItem(0)
                .buildForFragment();



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

    private void initNavDrawerProfile() {

        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.home_backpic)
                .addProfiles(
                        new ProfileDrawerItem().withName("Kristian Francisco")
                                .withEmail("piattosnovalays@gmail.com")
                                .withIcon(getResources().getDrawable(R.drawable.profile_pic))
                )
                .withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
                    @Override
                    public boolean onProfileImageClick(View view, IProfile profile, boolean current) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                        fragmentTransaction.replace(R.id.menu_frame, new UserProfileFragment(), "home");
                        fragmentTransaction.commit();
                        return false;
                    }

                    @Override
                    public boolean onProfileImageLongClick(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .build();

    }



    private void initNavDrawerItems() {


        home = new PrimaryDrawerItem()
                .withIdentifier(0)
                .withName("Home")
                .withIcon(CommunityMaterial.Icon.cmd_home);

        portfolio = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Portfolio")
                .withIcon(CommunityMaterial.Icon.cmd_folder_image);

        badges = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName("Badges")
                .withIcon(CommunityMaterial.Icon.cmd_ribbon);

        editProfile = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName("Edit Profile")
                .withIcon(CommunityMaterial.Icon.cmd_account_settings_variant);

        settings = new PrimaryDrawerItem()
                .withIdentifier(4)
                .withName("Settings")
                .withIcon(CommunityMaterial.Icon.cmd_settings);

        logOut = new PrimaryDrawerItem()
                .withIdentifier(5)
                .withName("Log Out")
                .withIcon(CommunityMaterial.Icon.cmd_logout);

        helpAndFeedback = new PrimaryDrawerItem()
                .withIdentifier(6)
                .withName("Help & Feedback")
                .withIcon(CommunityMaterial.Icon.cmd_help);

        reportBug = new PrimaryDrawerItem()
                .withIdentifier(7)
                .withName("Report Bug")
                .withIcon(CommunityMaterial.Icon.cmd_bug);

        aboutEthelon = new PrimaryDrawerItem()
                .withIdentifier(8)
                .withName("About Ethelon")
                .withIcon(CommunityMaterial.Icon.cmd_account_box_outline);
    }




}
