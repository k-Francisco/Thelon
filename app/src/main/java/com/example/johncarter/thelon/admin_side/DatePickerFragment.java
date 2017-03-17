package com.example.johncarter.thelon.admin_side;

import android.app.*;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

import java.util.Calendar;

/**
 * Created by Kristian Francisco on 3/17/2017.
 */

public class DatePickerFragment extends android.app.DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_WEEK);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String monthWord="";
        TextView date = (TextView) getActivity().findViewById(R.id.ac_date_text);


        switch (month){
            case 0:monthWord = "January";
                break;
            case 1:monthWord = "February";
                break;
            case 2:monthWord = "March";
                break;
            case 3:monthWord = "April";
                break;
            case 4:monthWord = "May";
                break;
            case 5:monthWord = "June";
                break;
            case 6:monthWord = "July";
                break;
            case 7:monthWord = "August";
                break;
            case 8:monthWord = "September";
                break;
            case 9:monthWord = "October";
                break;
            case 10:monthWord = "November";
                break;
            case 11:monthWord = "Decemberr";
                break;
        }

        date.setText(monthWord + " " + dayOfMonth + ", " + year);

    }
}
