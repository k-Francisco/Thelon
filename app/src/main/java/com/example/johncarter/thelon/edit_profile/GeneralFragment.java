package com.example.johncarter.thelon.edit_profile;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class GeneralFragment extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_general);
        Toolbar tool = (Toolbar)findViewById(R.id.nav_toolbar);
        setSupportActionBar(tool);
        getSupportActionBar().setTitle("Edit Profile");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       tool.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
        ImageView Work = (ImageView)findViewById(R.id.pen3);
        ImageView education = (ImageView)findViewById(R.id.pen2);
        ImageView Skills = (ImageView)findViewById(R.id.pen4);
        final ImageView BasicInfo = (ImageView)findViewById(R.id.pen1);
        BasicInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Toast.makeText(getContext(), "BasicInfo", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();
                BasicInfoDialogFragment dialog = new BasicInfoDialogFragment();
                dialog.show(fm,"EDIT BASIC INFO");
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Education", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();
                EducationalDialogFragment e = new EducationalDialogFragment();
                e.show(fm,"EDIT EDUCATION");
            }
        });
        Work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getContext(), "Work", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();
                Work e = new Work();
                e.show(fm,"EDIT WORK");
            }
        });
        Skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getContext(), "Skills", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();
                SkillsandHobbiesFragment s = new SkillsandHobbiesFragment();
                s.show(fm,"Skills and hobbies");
            }
        });


    }
}
