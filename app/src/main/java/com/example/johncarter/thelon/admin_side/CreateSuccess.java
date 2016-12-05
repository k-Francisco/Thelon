package com.example.johncarter.thelon.admin_side;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

/**
 * Created by Acer on 05/12/2016.
 */

public class CreateSuccess extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_success_layout);

        TextView doneBtn = (TextView) findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(CreateSuccess.this,Foundation_Main.class));
            }
        });
    }
}
