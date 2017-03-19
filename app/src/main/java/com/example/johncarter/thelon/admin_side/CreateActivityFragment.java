package com.example.johncarter.thelon.admin_side;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.johncarter.thelon.R;
import com.firebase.client.Firebase;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

/**
 * Created by asus on 03/12/2016.
 */

public class CreateActivityFragment extends Fragment  {

    ArrayList<Bitmap> images = new ArrayList<>();
    EditText name;
    TextView date;
    EditText street;
    EditText city;
    TextView time;
    Foundation_Main fm;
    EditText address;
    ArrayList<String> pics;
    EditText category;
    Firebase mrefActivities;
    View rootView;
    private int PICK_IMAGE_REQUEST = 7;
    Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.admin_create_activity,container,false);
        ImageView photoPicker = (ImageView) rootView.findViewById(R.id.photoPicker);

        final Calendar calendar = Calendar.getInstance();

        name = (EditText)rootView.findViewById(R.id.ac_name_txt);
        date = (TextView)rootView.findViewById(R.id.ac_date_text);
        street = (EditText)rootView.findViewById(R.id.ac_street_text);
        city = (EditText)rootView.findViewById(R.id.ac_city_text);
        address = (EditText)rootView.findViewById(R.id.ac_location_text);
        time = (TextView)rootView.findViewById(R.id.ac_time_text);
        pics = new ArrayList<>();
       // category = (EditText)rootView.findViewById(R.id.ac)
        mrefActivities = new Firebase("https://ethelon-33583.firebaseio.com/Activity");

        FrameLayout step2 = (FrameLayout) rootView.findViewById(R.id.step2);
        final FragmentManager fm = getFragmentManager();
        fm.beginTransaction().add(new CreateActivityFragment(),"step1");

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timeFragment = new TimePickerFragment();
                timeFragment.show(getFragmentManager(), "wtf");
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

               /* DialogFragment newFr = new com.example.johncarter.thelon.admin_side.DialogFragment();
                newFr.show(getFragmentManager(),"date");*/

                DialogFragment dateFragment = new DatePickerFragment();
                dateFragment.show(getFragmentManager(), "wtf");
            }
        });

        if(getArguments() != null){
         String editName = getArguments().getString("editName");
         String editDate = getArguments().getString("editDate");
         String editStreet = getArguments().getString("editStreet");
         String editCity = getArguments().getString("editCity");
         String editAddress = getArguments().getString("editAddress");
         String editTime = getArguments().getString("editTime");
      //   String pic = getArguments().getString("pic");

            name.setText(editName);
            date.setText(editDate);
            city.setText(editCity);
            street.setText(editStreet);
            address.setText(editAddress);
            time.setText(editTime);
        //    pics.add(pic);

        }

        step2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //CreateActivity3Fragment act3 = new CreateActivity3Fragment();
                CreateActivity2Fragment frag = new CreateActivity2Fragment();
                FragmentManager fm = getFragmentManager();

                if(pics.size() == 0 ||name.getText().toString().equals("") || date.getText().toString().equals("")
                        || city.getText().toString().equals("") || street.getText().toString().equals("")
                        || address.getText().toString().equals("") || time.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please Supply the following fields properly", Toast.LENGTH_SHORT).show();
                }
                else {
                    Bundle args = new Bundle();
                    args.putString("name", name.getText().toString());
                    args.putString("date", date.getText().toString());
                    args.putString("street", street.getText().toString());
                    args.putString("city", city.getText().toString());
                    args.putString("address", address.getText().toString());
                    args.putString("time", time.getText().toString());
                    args.putStringArrayList("photoList", pics);

                    if(getArguments().getString("ilhanan").equals("create")){
                        Log.e("kelsey","ni sud sa getArguments == null");
                        args.putString("ilhanan","create");
                        frag.setArguments(args);
                        fm.beginTransaction().replace(R.id.fram2, frag).addToBackStack("step1").commit();
                    }else {
                        String editLocation = getArguments().getString("editLocation");
                        String editGender = getArguments().getString("editGender");
                        String editAge = getArguments().getString("editAge");
                        String editOccupation = getArguments().getString("editOccupation");
                        String editPersonInCharge = getArguments().getString("editPersonInCharge");
                        String editPersonContactNumber = getArguments().getString("editPersonContactNumber");
                        String editEmail = getArguments().getString("editEmail");
                        String key = getArguments().getString("ActivityKeyIfEdit");
                        Log.e("kelsey","key = "+key);

                        args.putString("editLocation",editLocation);
                        args.putString("editGender",editGender);
                        args.putString("editAge",editAge);
                        args.putString("editOccupation",editOccupation);


                        args.putString("editPersonInCharge",editPersonInCharge);
                        args.putString("editPersonContactNumber",editPersonContactNumber);
                        args.putString("editEmail",editEmail);

                        args.putString("ActivityKeyIfEdit",key);
                        args.putString("ilhanan","edit");

                        frag.setArguments(args);
                        fm.beginTransaction().replace(R.id.fram2, frag).addToBackStack("step1").commit();
                    }
                }

            }
        });

        photoPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),PICK_IMAGE_REQUEST);
            }
        });
        return rootView;
    }

    public void setAct(Foundation_Main fm){
        this.fm = fm;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri uri = data.getData();
            String indPic = uri.toString();
            pics.add(indPic);

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                images.add(bitmap);
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.ascPics_recycler);
                RecyclerView.Adapter adapter = new AssociatedPicsAdapter2(images);
                recyclerView.setAdapter(adapter);
                GridLayoutManager gm = new GridLayoutManager(rootView.getContext(),2);
                recyclerView.setLayoutManager(gm);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void setText(String dateText){
        Log.e("kobe",""+dateText+"met");
        if(dateText != null ) {
            date.setText(dateText);
        }
    }

    public void setContext(Context context){
        mContext = context;
    }
}
