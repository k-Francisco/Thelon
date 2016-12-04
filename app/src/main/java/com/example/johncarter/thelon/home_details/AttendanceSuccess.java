package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by Acer on 04/12/2016.
 */

public class AttendanceSuccess extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.attendance_success_layout);

        TextView evaluateBtn = (TextView) findViewById(R.id.evaluateBtn);
        evaluateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AttendanceSuccess.this,EvaluationActivity.class));
            }
        });
    }
}
