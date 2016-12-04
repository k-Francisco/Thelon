package com.example.johncarter.thelon.main_screens;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.johncarter.thelon.BadgeBadge;
import com.example.johncarter.thelon.admin_side.ActivitiesFragment;
import com.example.johncarter.thelon.admin_side.BlankFragment;
import com.example.johncarter.thelon.edit_profile.GeneralFragment;
import com.example.johncarter.thelon.home_details.HomeDetailsFragment;
import com.example.johncarter.thelon.home_details.home_details;
import com.example.johncarter.thelon.home_tab.ActivitiesMainFragment;
import com.example.johncarter.thelon.portfolio.Portfolio;
import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.BadgeFragment;
import com.example.johncarter.thelon.fragments.GifWebviewFragment;
import com.example.johncarter.thelon.fragments.HomeFragment;
import com.example.johncarter.thelon.fragments.LeaderBoardFragment;
import com.example.johncarter.thelon.fragments.NotificationFragment;
import com.example.johncarter.thelon.fragments.UserProfileFragment;
import com.example.johncarter.thelon.login_signup.Login;
import com.example.johncarter.thelon.profile_tab.ProfileActivity;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.qslll.library.ExpandingPagerFactory;
import com.qslll.library.fragments.ExpandingFragment;

import br.com.mauker.materialsearchview.MaterialSearchView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;
import android.support.v7.app.ActionBarDrawerToggle;

public class LandingPage extends AppCompatActivity implements BottomNavigation.OnMenuItemSelectionListener, ExpandingFragment.OnExpandingClickListener {

    PrimaryDrawerItem home,  badges, editProfile, settings, logOut, partners, helpAndFeedback, reportBug, aboutEthelon;
    AccountHeader accountHeader;
    BottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Window window;
    Drawer drawer;
    Toolbar toolbar;
    MaterialSearchView searchView;
    private int fragmentIdentifier =0;

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
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_frame, new ActivitiesMainFragment());
        fragmentTransaction.commit();
        fragmentIdentifier = 1;
        //window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_home));

        //Initializes toolbar and searchbar
        searchView = (MaterialSearchView)findViewById(R.id.search_view);
        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.adminhamburger);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer();
            }
        });
        initSearchBar();

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawer.openDrawer();
//            }
//        });



        //Initializes drawer items
        initNavDrawerItems();

        //Initializes drawer profile
        initNavDrawerProfile();

        //creates the navigation drawer with the profile and items
        drawer = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withActivity(this)
                .addDrawerItems(
                        home,
                        badges,
                        editProfile,
                        settings,
                        logOut,
                        new DividerDrawerItem(),
                        partners,
                        helpAndFeedback,
                        reportBug,
                        aboutEthelon

                )
                .withSelectedItem(0)
                .buildForFragment();



    }
//////Searchbar Start
    private void initSearchBar() {

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewOpened() {
                // Do something once the view is open.
                toolbar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onSearchViewClosed() {
                // Do something once the view is closed.
                toolbar.setVisibility(View.VISIBLE);
            }
        });

        searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Do something when the suggestion list is clicked.
                String suggestion = searchView.getSuggestionAtPosition(position);

                searchView.setQuery(suggestion, false);
            }
        });

        searchView.adjustTintAlpha(0.8f);
        final Context context = this;
        searchView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "Long clicked position: " + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        searchView.setOnVoiceClickedListener(new MaterialSearchView.OnVoiceClickedListener() {
            @Override
            public void onVoiceClicked() {
                Toast.makeText(context, "Voice clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void removeFrag(int identifier) {
//        if(identifier == 1)
//            fragmentTransaction.remove(getFragmentManager().findFragmentById(R.id.menu_frame)).commit();
//        else if (identifier == 2)
//            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.)).commit();
//        else if(identifier == 3)
//            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.)).commit();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle toolbar item clicks here. It'll
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                // Open the search view on the menu item click.


                searchView.openSearch();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (searchView.isOpen()) {
            // Close the search on the back button press.
            searchView.closeSearch();


        } else {
            super.onBackPressed();

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }
////Searchbar End

    @Override
    public void onMenuItemSelect(@IdRes int i, int i1, boolean b) {


        switch (i1){
            case 0:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                fragmentTransaction.replace(R.id.menu_frame, new ActivitiesMainFragment(), "home");
                fragmentTransaction.commit();
                fragmentIdentifier = 1;
                //window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_home));

                break;
            case 1:
                fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
                fragmentTransaction.replace(R.id.menu_frame, new NotificationFragment(), "notification");
                fragmentTransaction.commit();
                fragmentIdentifier = 2;
                //window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_notification));
                break;

            case 2:
                fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
                fragmentTransaction.replace(R.id.menu_frame, new LeaderBoardFragment(), "leaderboard");
                fragmentTransaction.commit();
                fragmentIdentifier = 3;
                //window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_leaderboard));
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
//                        fragmentTransaction = fragmentManager.beginTransaction();
//                        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
//                        fragmentTransaction.replace(R.id.menu_frame, new UserProfileFragment(), "home");
//                        fragmentTransaction.commit();
//                        return false;
                        Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(in);
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


        badges = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName("Badges")
                .withIcon(CommunityMaterial.Icon.cmd_ribbon)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){

            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                    Intent intent = new Intent(LandingPage.this, BadgeBadge.class);
                startActivity(intent);

                return false;
            }
        });

        editProfile = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName("Edit Profile")
                .withIcon(CommunityMaterial.Icon.cmd_account_settings_variant)
        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                Intent intent = new Intent(LandingPage.this, GeneralFragment.class);
                startActivity(intent);
                return false;
            }
        });

        settings = new PrimaryDrawerItem()
                .withIdentifier(4)
                .withName("Settings")
                .withIcon(CommunityMaterial.Icon.cmd_settings)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        Intent intent = new Intent(LandingPage.this, Settings.class);
                        startActivity(intent);
                        return false;
                    }
                });


        logOut = new PrimaryDrawerItem()
                .withIdentifier(5)
                .withName("Log Out")
                .withIcon(CommunityMaterial.Icon.cmd_logout)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        Intent intent = new Intent(LandingPage.this, Login.class);
                        startActivity(intent);
                        finish();
                        return false;
                    }
                });

        partners = new PrimaryDrawerItem()
                .withIdentifier(6)
                .withName("Partnered Foundation")
                .withIcon(CommunityMaterial.Icon.cmd_account_network);

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


    @Override
    public void onExpandingClick(View view) {
        startActivity(new Intent(view.getContext(),home_details.class));
    }
}
