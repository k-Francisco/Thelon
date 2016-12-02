package com.example.johncarter.thelon.admin_side;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundation_profile);
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
