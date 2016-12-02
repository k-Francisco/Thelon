package com.example.johncarter.thelon.admin_side;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.profile_tab.ProfileActivity;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import br.com.mauker.materialsearchview.MaterialSearchView;


public class Foundation_Main extends AppCompatActivity {
    MaterialSearchView searchView;
    PrimaryDrawerItem home,foundation_profile,settings,logout;
    AccountHeader accountHeader;
    Drawer drawer;
    Toolbar toolbar;
    TabLayout tab;

    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundation__main);
        searchView = (MaterialSearchView)findViewById(R.id.search_view);


        tab = (TabLayout) findViewById(R.id.tab_menu);
        tab.addTab(tab.newTab().setText("Activities"));
        tab.addTab(tab.newTab().setText("Volunteers"));

        fm = getFragmentManager();
        fm.beginTransaction().add(new ActivitiesFragment(),"act_main").commit();
        fm.beginTransaction().replace(R.id.fram2,new ActivitiesFragment()).commit();
        fm.beginTransaction().add(new CreateActivityFragment(),"create_act").commit();
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    fm.beginTransaction().replace(R.id.fram2,new ActivitiesFragment()).addToBackStack("volunteers").commit();
                }
                else if(tab.getPosition() == 1) {
                    fm.beginTransaction().replace(R.id.fram2, new AdminVolunteer()).addToBackStack("volunteers").commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer();
            }
        });

        initSearchBar();
        initDrawerItems();
        initDrawerHeader();



        drawer = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withActivity(this)
                .addDrawerItems(
                        home,
                        foundation_profile,
                        settings,
                        logout
                )
                .withTranslucentStatusBar(false)
                .withTranslucentNavigationBar(false)
                .withDisplayBelowStatusBar(true)
                .withFullscreen(false)
                .withSelectedItem(0)
                .build();
    }

    private void initDrawerHeader() {
        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.login_background)
                .addProfiles(
                        new ProfileDrawerItem().withName("Kristian Francisco")
                                .withEmail("piattosnovalays@gmail.com")
                                .withIcon(getResources().getDrawable(R.drawable.profile_pic))
                )
                .withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
                    @Override
                    public boolean onProfileImageClick(View view, IProfile profile, boolean current) {
                    Intent s = new Intent(Foundation_Main.this,foundation_profile.class);
                        startActivity(s);
                        return false;
                    }

                    @Override
                    public boolean onProfileImageLongClick(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .build();
    }

    private void initDrawerItems() {

        home = new PrimaryDrawerItem()
                .withIdentifier(0)
                .withName("Home")
                .withIcon(CommunityMaterial.Icon.cmd_home);

        foundation_profile = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Foundation Profile")
                .withIcon(CommunityMaterial.Icon.cmd_face_profile);

        settings = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName("Settings")
                .withIcon(CommunityMaterial.Icon.cmd_settings);
        logout = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName("Logout")
                .withIcon(CommunityMaterial.Icon.cmd_logout);


    }

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
                tab.setVisibility(View.INVISIBLE);
                toolbar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onSearchViewClosed() {
                // Do something once the view is closed.
                tab.setVisibility(View.VISIBLE);
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


}
