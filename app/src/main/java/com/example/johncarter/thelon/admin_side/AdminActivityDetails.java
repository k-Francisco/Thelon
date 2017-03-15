package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.johncarter.thelon.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;

/**
 * Created by asus on 03/12/2016.
 */

public class AdminActivityDetails extends Fragment {
    FragmentManager fm;
    ImageView qrCodeImg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_activity_details,container,false);
        qrCodeImg = (ImageView) rootView.findViewById(R.id.qrCodeImg);
        TabLayout tab = (TabLayout) rootView.findViewById(R.id.tab_menu);
        tab.addTab(tab.newTab().setText("Overview"));
        tab.addTab(tab.newTab().setText("Requirements"));
        tab.addTab(tab.newTab().setText("Contact Person"));
        Bundle args = getArguments();
        String sr = args.getString("qr");
        //Log.d("charles",url);
        //TODO Glide.with(rootView.getContext()).using(new FirebaseImageLoader()).load().into(qrCodeImg);
        fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.detailsFrame, new DetailsOverviewFragment()).commit();
        fm.beginTransaction().replace(R.id.volunteersFrame, new VolunteersInDetailsFragment()).commit();
        fm.beginTransaction().replace(R.id.ascPicsFrame, new StaggeredAscPicsFragment()).commit();
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    fm.beginTransaction().replace(R.id.detailsFrame, new DetailsOverviewFragment()).commit();
                }
                else if(tab.getPosition() == 1){
                    fm.beginTransaction().replace(R.id.detailsFrame,new DetailsRequirementFragment()).commit();
                }
                else if(tab.getPosition() == 2){
                    fm.beginTransaction().replace(R.id.detailsFrame,new DetailsContactFragment()).commit();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    public void setQrCodeImg(StorageReference storageReference, Context context){
        if(context == null){
            Log.d("charles","context is null");
        }
        Glide.with(context).using(new FirebaseImageLoader()).load(storageReference).into(qrCodeImg);
        Log.d("charles",storageReference.toString());
    }

}
