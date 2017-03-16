package com.example.johncarter.thelon.admin_side;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.johncarter.thelon.R;

import java.util.Calendar;

/**
 * Created by asus on 09/03/2017.
 */

public class DialogFragment extends android.app.DialogFragment implements DatePickerDialog.OnDateSetListener {

    String date;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        date = month +""+ dayOfMonth + year;
        Log.e("kobe",""+date);

        //ds.setText(date);

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
