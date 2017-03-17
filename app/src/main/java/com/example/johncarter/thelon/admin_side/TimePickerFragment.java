package com.example.johncarter.thelon.admin_side;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;


import com.android.datetimepicker.time.RadialPickerLayout;
import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.DialogFragment;
import com.example.johncarter.thelon.admin_side.Foundation_Main;

import java.util.Calendar;

/**
 * Created by Kristian Francisco on 3/17/2017.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    Foundation_Main fm;

    public TimePickerFragment(){

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute
        , DateFormat.is24HourFormat(getActivity()));
    }

    public void setParentActivity(Foundation_Main fm){

        this.fm = fm;
    }

     @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

         TextView time = (TextView) getActivity().findViewById(R.id.ac_time_text);
         time.setText(String.valueOf(hourOfDay)+" : " + String.valueOf(minute)+"");

    }
}
