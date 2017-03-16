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


        VolunteersFragment vm = new VolunteersFragment();
        vm.setViewzz(rootView);
        fm.beginTransaction().replace(R.id.rec_vol_frame,vm).commit();

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateActivity3Fragment act3 = new CreateActivity3Fragment();
                Bundle args = new Bundle();
                String name = getArguments().getString("name");
                String date = getArguments().getString("date");
                String street = getArguments().getString("street");
                String city = getArguments().getString("city");
                String address = getArguments().getString("address");
                String time = getArguments().getString("time");
                ArrayList<String >photoList = getArguments().getStringArrayList("photoList");


                args.putStringArrayList("photoList",photoList);
                args.putString("name",name);
                args.putString("date",date);
                args.putString("street",street);
                args.putString("city",city);
                args.putString("address",address);
                args.putString("time",time);

                Log.e("step2"," "+locd.getText().toString()+genderd.getText().toString()+occupationd.getText().toString()+aged.getText().toString());

                args.putString("location",locd.getText().toString());
                args.putString("gender",genderd.getText().toString());
                args.putString("age",aged.getText().toString());
                args.putString("occupation",occupationd.getText().toString());

                if(locd.getText().toString().equals("") || genderd.getText().toString().equals("") ||
                        aged.getText().toString().equals("") || occupationd.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please Supply the fields properly", Toast.LENGTH_SHORT).show();
                }else{
                    act3.setArguments(args);
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.fram2,act3).addToBackStack("step2").commit();
                }
            }
        });

        return rootView;
    }
}
