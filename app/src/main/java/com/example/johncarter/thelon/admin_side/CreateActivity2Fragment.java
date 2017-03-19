package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;

/**
 * Created by asus on 03/12/2016.
 */

public class CreateActivity2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_create_activity2,container,false);
        FragmentManager fm = getFragmentManager();
        FrameLayout step3 = (FrameLayout) rootView.findViewById(R.id.step3);
         final EditText locd = (EditText)rootView.findViewById(R.id.ac_location_text);
          final EditText genderd = (EditText)rootView.findViewById(R.id.ed_gender);
          final EditText aged = (EditText)rootView.findViewById(R.id.ed_age);
        final EditText occupationd = (EditText)rootView.findViewById(R.id.ed_occupation);

        final String location = locd.getText().toString();
        final String gender = genderd.getText().toString();
        final String occupation = occupationd.getText().toString();
        final String age = aged.getText().toString();

        if(getArguments().getString("ilhanan").equals("edit")){
            String editLocation = getArguments().getString("editLocation");
            String editGender = getArguments().getString("editGender");
            String editAge = getArguments().getString("editAge");
            String editOccupation = getArguments().getString("editOccupation");

            locd.setText(editLocation);
            genderd.setText(editGender);
            aged.setText(editAge);
            occupationd.setText(editOccupation);

        }

        VolunteersFragment vm = new VolunteersFragment();
        vm.setViewzz(rootView);
        fm.beginTransaction().replace(R.id.rec_vol_frame,vm).commit();

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateActivity3Fragment act3 = new CreateActivity3Fragment();
                FragmentManager fm = getFragmentManager();

                if(locd.getText().toString().equals("") || genderd.getText().toString().equals("") ||
                        aged.getText().toString().equals("") || occupationd.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please Supply the fields properly", Toast.LENGTH_SHORT).show();
                }else {
                    Bundle args = new Bundle();
                    //gikan first
                    String name = getArguments().getString("name");
                    String date = getArguments().getString("date");
                    String street = getArguments().getString("street");
                    String city = getArguments().getString("city");
                    String address = getArguments().getString("address");
                    String time = getArguments().getString("time");
                    //pasa ang first og second
                    args.putString("location", locd.getText().toString());
                    args.putString("gender", genderd.getText().toString());
                    args.putString("age", aged.getText().toString());
                    args.putString("occupation", occupationd.getText().toString());
                    ArrayList<String> photoList = getArguments().getStringArrayList("photoList");
                    args.putStringArrayList("photoList", photoList);
                    args.putString("name",name);
                    args.putString("date",date);
                    args.putString("street",street);
                    args.putString("city",city);
                    args.putString("address",address);
                    args.putString("time",time);

                    if(getArguments().getString("ilhanan").equals("create")) {
                        args.putString("ilhanan","create");
                        act3.setArguments(args);
                        fm.beginTransaction().replace(R.id.fram2,act3).commit();
                    }else {
                        //i getArguments ang mga Edit
                        String editPersonInCharge = getArguments().getString("editPersonInCharge");
                        String editPersonContactNumber = getArguments().getString("editPersonContactNumber");
                        String editEmail = getArguments().getString("editEmail");

                        args.putString("editPersonInCharge", editPersonInCharge);
                        args.putString("editPersonContactNumber", editPersonContactNumber);
                        args.putString("editEmail", editEmail);

                        String key = getArguments().getString("ActivityKeyIfEdit");
                        args.putString("ActivityKeyIfEdit", key);
                        args.putString("ilhanan","edit");
                        act3.setArguments(args);
                        fm.beginTransaction().replace(R.id.fram2, act3).commit();
                    }

                }
            }
        });

        return rootView;
    }
}
