package com.example.johncarter.thelon.admin_side;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.johncarter.thelon.R;

public class admin_welcome extends AppCompatActivity {

    private Button mSetUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_welcome);

        mSetUp = (Button) findViewById(R.id.setupProfile);
        mSetUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_welcome.this, foundation_profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
