package com.example.johncarter.thelon.admin_side;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.johncarter.thelon.R;

/**
 * Created by Acer on 04/12/2016.
 */

public class ReferVolunteerFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_layout_rever,container,false);

        getDialog().setTitle("Refer volunteers: ");
        FragmentManager fm = getChildFragmentManager();
        fm.beginTransaction().replace(R.id.dialogFrame,new VolunteersFragment()).commit();
        return rootView;
    }
}

