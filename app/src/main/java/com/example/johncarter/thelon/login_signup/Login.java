package com.example.johncarter.thelon.login_signup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.johncarter.thelon.admin_side.admin_welcome;
import com.example.johncarter.thelon.main_screens.LandingPage;
import com.example.johncarter.thelon.R;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextView mSignup;
    private Button mLoginButton, mFoundation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        mSignup = (TextView) findViewById(R.id.signup);
        mLoginButton = (Button) findViewById(R.id.button);
        mFoundation = (Button) findViewById(R.id.foundation);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case  R.id.signup:
                intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();
                break;
            case R.id.button:
                    intent = new Intent(Login.this, LandingPage.class);
                    startActivity(intent);
                    finish();
                break;

            case R.id.foundation:
                intent = new Intent(Login.this, admin_welcome.class);
                startActivity(intent);
                finish();
                break;


        }
    }
}
