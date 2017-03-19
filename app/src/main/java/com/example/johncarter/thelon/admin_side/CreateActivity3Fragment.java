package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.models.Activity;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.zxing.qrcode.encoder.QRCode;

import net.glxn.qrgen.core.image.ImageType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by asus on 03/12/2016.
 */

public class CreateActivity3Fragment extends Fragment {

    Firebase mrootAct;
    StorageReference storageReference;
    StorageReference mref;
    Firebase activityPhotosRef;
    Firebase activityQrCodes;
    int ilhananKungEditBahorCreateRah = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.admin_create_activity3,container,false);
        TextView img = (TextView) rootView.findViewById(R.id.completeBtn) ;


        mref = FirebaseStorage.getInstance().getReference();
        mrootAct = new Firebase("https://ethelon-33583.firebaseio.com/Activity");
        activityPhotosRef = new Firebase("https://ethelon-33583.firebaseio.com/ActivityPhotos");
        activityQrCodes = new Firebase("https://ethelon-33583.firebaseio.com/ActivityQR");

       final EditText poc = (EditText)rootView.findViewById(R.id.poc_txt);
        final EditText cot = (EditText)rootView.findViewById(R.id.contact_txt);
        final EditText em = (EditText)rootView.findViewById(R.id.email_txt);

        if(getArguments().getString("ilhanan").equals("edit")){
            String editPersonInCharge = getArguments().getString("editPersonInCharge");
            String editPersonContactNumber  = getArguments().getString("editPersonContactNumber");
            String editEmail = getArguments().getString("editEmail");

            poc.setText(editPersonInCharge);
            cot.setText(editPersonContactNumber);
            em.setText(editEmail);
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(poc.getText().toString().equals("")||cot.getText().toString().equals("")||em.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please Supply the fields properly", Toast.LENGTH_SHORT).show();
                }else{

                }

                String name = getArguments().getString("name");
                String date = getArguments().getString("date");
                String street = getArguments().getString("street");
                String city = getArguments().getString("city");
                String address = getArguments().getString("address");
                String time = getArguments().getString("time");
                String location = getArguments().getString("location");
                String gender = getArguments().getString("gender");
                String occupation = getArguments().getString("occupation");
                String age = getArguments().getString("age");
                ArrayList<String> photoList = getArguments().getStringArrayList("photoList");

                Log.e("kyla","vlocation = "+location+"\ngender = "+gender+"\noccupation = "+occupation
                +"\nage = "+age);

                if(getArguments().getString("ilhanan").equals("create")) {
                    Toast.makeText(getActivity(), "NI SUD SA ILHANAN CREATE", Toast.LENGTH_LONG).show();
                    final Firebase root = mrootAct.push();
                    for (int i = 0; i < photoList.size(); i++) {
                        final Uri uri = Uri.parse(photoList.get(i));
                        Log.e("kobe", "" + uri.getLastPathSegment());
                        Log.e("charles", "" + photoList.size());
                        storageReference = mref.child("ActivityPhotos").child(root.getKey()).child(uri.getLastPathSegment());


                        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // activityPhotosRef.child(root.getKey()).push().child("Url").setValue(taskSnapshot.getDownloadUrl().toString());
                                activityPhotosRef.child(root.getKey()).child("Url").setValue(uri.getLastPathSegment());
                                Log.d("kobe", "good " + taskSnapshot.getDownloadUrl().toString());
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Upload Failed", Toast.LENGTH_LONG).show();
                                Log.e("kobe", "fail");

                            }
                        });
                    }

                    Activity activity = new Activity(name, date, time, street, city, address, "Ethelon", "Ethelon", poc.getText().toString(),
                            cot.getText().toString(), em.getText().toString(), location, gender, occupation, age, root.getKey());
                    root.setValue(activity);
                    Log.e("charles", " location =" + activity.getvLocation() + " age = " + activity.getvAge() + " Gender = " +
                            activity.getvGender() + " Occuption = " + activity.getvOccupation());
                    Log.e("charles", root.getKey());
                    generateQrCode(root);
                    startActivity(new Intent(rootView.getContext(),CreateSuccess.class));
                }else{
                    Toast.makeText(getActivity(), "NI SUD SA ILHANAN EDIT", Toast.LENGTH_LONG).show();
                    //final Firebase root = mrootAct.push();
                    final String key = getArguments().getString("ActivityKeyIfEdit");
                    for (int i = 0; i < photoList.size(); i++) {
                        final Uri uri = Uri.parse(photoList.get(i));
                        Log.e("kobe", "" + uri.getLastPathSegment());
                        Log.e("charles", "" + photoList.size());
                        storageReference = mref.child("ActivityPhotos").child(key).child(uri.getLastPathSegment());
                        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // activityPhotosRef.child(root.getKey()).push().child("Url").setValue(taskSnapshot.getDownloadUrl().toString());
                                activityPhotosRef.child(key).child("Url").setValue(uri.getLastPathSegment());
                                Log.d("kobe", "good " + taskSnapshot.getDownloadUrl().toString());
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Upload Failed", Toast.LENGTH_LONG).show();
                                Log.e("kobe", "fail");

                            }
                        });
                    }

                    Activity activity = new Activity(name, date, time, street, city, address, "Ethelon", "Ethelon", poc.getText().toString(),
                            cot.getText().toString(), em.getText().toString(), location, gender, occupation, age, key);
                    mrootAct.child(key).setValue(activity);
                    Log.e("charles", " location =" + activity.getvLocation() + " age = " + activity.getvAge() + " Gender = " +
                            activity.getvGender() + " Occuption = " + activity.getvOccupation());
                    //generateQrCode(key);
                    startActivity(new Intent(rootView.getContext(),CreateSuccess.class));
                }

            }
        });
        return rootView;
    }

    public void generateQrCode(final Firebase root){
        File file = net.glxn.qrgen.android.QRCode.from(root.getKey()).to(ImageType.JPG).withSize(250,250).file();
        final Uri uri = Uri.fromFile(file);
        storageReference  = mref.child("ActivityQR").child(root.getKey()).child(uri.getLastPathSegment());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                activityQrCodes.child(root.getKey()).push().child("Url").setValue(uri.getLastPathSegment());
                Toast.makeText(getActivity(), "Upload Success", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"Upload Failed",Toast.LENGTH_SHORT);
            }
        });
    }
}
