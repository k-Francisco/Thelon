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

        Bundle bundle = getArguments();
        QrCode qrCode = bundle.getParcelable("qrcode");
        Glide.with(getActivity()).using(new FirebaseImageLoader()).load(qrCode.getStorageReference()).into(qrCodeImg);

        fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.volunteersFrame, new VolunteersInDetailsFragment()).commit();
        fm.beginTransaction().replace(R.id.ascPicsFrame, new StaggeredAscPicsFragment()).commit();
        return rootView;
    }
}
