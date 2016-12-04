package com.example.johncarter.thelon.home_details;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.StaggeredAscPicsFragment;
import com.example.johncarter.thelon.admin_side.VolunteersInDetailsFragment;

/**
 * Created by Acer on 04/12/2016.
 */

public class HomeDetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home_details2,container,false);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.volunteersFrame, new VolunteersInDetailsFragment()).commit();
        fm.beginTransaction().replace(R.id.ascPicsFrame, new StaggeredAscPicsFragment()).commit();
        fm.beginTransaction().replace(R.id.commentsFrame, new CommentsFragment()).commit();

        return rootView;
    }
}
