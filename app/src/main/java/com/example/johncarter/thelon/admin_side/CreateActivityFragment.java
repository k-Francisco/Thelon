package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by asus on 03/12/2016.
 */

public class CreateActivityFragment extends Fragment {
    ArrayList<Bitmap> images = new ArrayList<>();
    View rootView;
    private int PICK_IMAGE_REQUEST = 7;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.admin_create_activity,container,false);
        ImageView photoPicker = (ImageView) rootView.findViewById(R.id.photoPicker);

        FrameLayout step2 = (FrameLayout) rootView.findViewById(R.id.step2);
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().add(new CreateActivityFragment(),"step1");

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fram2,new CreateActivity2Fragment()).addToBackStack("step1").commit();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri uri = data.getData();

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
}
