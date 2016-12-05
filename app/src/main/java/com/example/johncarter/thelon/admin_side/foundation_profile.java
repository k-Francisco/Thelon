package com.example.johncarter.thelon.admin_side;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.johncarter.thelon.R;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class foundation_profile extends AppCompatActivity {

    PrimaryDrawerItem home,foundation_profile,settings,logout;
    AccountHeader accountHeader;
    Drawer drawer;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundation_profile);
        initDrawerItems();
        initDrawerHeader();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackground(null);
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(foundation_profile.this, Foundation_Main.class);
                startActivity(intent);
                finish();
            }
        });


        recyclerView = (RecyclerView) this.findViewById(R.id.foundation_activities);
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager = linearLayoutManager;

        recyclerView.setLayoutManager(layoutManager);
        adapter = new FoundationActivitiesAdapter();
        recyclerView.setAdapter(adapter);




//        drawer = new DrawerBuilder()
//                .withAccountHeader(accountHeader)
//                .withActivity(this)
//                .addDrawerItems(
//                        home,
//                        foundation_profile,
//                        settings,
//                        logout
//                )
//                .withSelectedItem(1)
//                .build();
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
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
                .withIcon(CommunityMaterial.Icon.cmd_home)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Intent s = new Intent(foundation_profile.this,Foundation_Main.class);
                        startActivity(s);
                        return false;
                    }
                });

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
}
