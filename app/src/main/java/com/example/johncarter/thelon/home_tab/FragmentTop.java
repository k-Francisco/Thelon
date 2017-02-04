package com.example.johncarter.thelon.home_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.johncarter.thelon.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Acer on 04/12/2016.
 */

public class FragmentTop extends Fragment {

    static final String ARG_TRAVEL = "ARG_TRAVEL";
    Travel travel;

    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.title)
    TextView title;

    public static FragmentTop newInstance(Travel travel) {
        Bundle args = new Bundle();
        FragmentTop fragmentTop = new FragmentTop();
        args.putParcelable(ARG_TRAVEL, travel);
        fragmentTop.setArguments(args);
        return fragmentTop;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            travel = args.getParcelable(ARG_TRAVEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_front, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if (travel != null) {
            Glide.with(getActivity()).using(new FirebaseImageLoader()).load(travel.getImage()).into(image);
            title.setText(travel.getName());
          //  Log.e("Anton","Fragment Top "+travel.getName());
        }

    }
}
