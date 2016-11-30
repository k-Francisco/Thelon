package com.example.johncarter.thelon.profile_tab;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.fragments.NotificationFragment;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_menu);
        tab.addTab(tab.newTab().setText("Portfolio"));
        tab.addTab(tab.newTab().setText("Badges"));
        tab.addTab(tab.newTab().setText("Reedemables"));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            FragmentManager fm = getFragmentManager();
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0)
                    fm.beginTransaction().replace(R.id.frameyy,new NotificationFragment()).commit();
                else if(tab.getPosition() == 1)
                    fm.beginTransaction().replace(R.id.frameyy,new BadgeListFragment()).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
