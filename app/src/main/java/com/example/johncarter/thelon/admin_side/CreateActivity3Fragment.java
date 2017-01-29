package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.models.Activity;
import com.firebase.client.Firebase;

import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by asus on 03/12/2016.
 */

public class CreateActivity3Fragment extends Fragment {

    Firebase mrootAct;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.admin_create_activity3,container,false);
        TextView img = (TextView) rootView.findViewById(R.id.completeBtn) ;

        mrootAct = new Firebase("https://ethelon-33583.firebaseio.com/Activity");

       final EditText poc = (EditText)rootView.findViewById(R.id.poc_txt);
        final EditText cot = (EditText)rootView.findViewById(R.id.contact_txt);
        final EditText em = (EditText)rootView.findViewById(R.id.email_txt);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getArguments().getString("name");
                String date = getArguments().getString("date");
                String street = getArguments().getString("street");
                String city = getArguments().getString("city");
                String address = getArguments().getString("address");
                String time = getArguments().getString("time");
                String vlocation = getArguments().getString("vlocation");
                String gender = getArguments().getString("gender");
                String occupation = getArguments().getString("occupation");
                String age = getArguments().getString("age");

                Firebase root = mrootAct.push();
                Activity activity = new Activity(name,date,time,street,city,address,"Ethelon","Ethelon",poc.getText().toString(),cot.getText().toString(),em.getText().toString(),vlocation,gender,occupation,age,root.getKey());
                root.setValue(activity);
                startActivity(new Intent(rootView.getContext(),CreateSuccess.class));
            }
        });


        return rootView;
    }
}
