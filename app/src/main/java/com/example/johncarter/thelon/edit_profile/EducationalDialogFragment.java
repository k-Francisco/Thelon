package com.example.johncarter.thelon.edit_profile;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class EducationalDialogFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.educationdialog, container, false);

        Button but = (Button)view.findViewById(R.id.button);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        getDialog().setTitle("EDUCATION");
        return view;
    }
}
