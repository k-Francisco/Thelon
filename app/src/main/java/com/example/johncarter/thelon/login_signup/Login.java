package com.example.johncarter.thelon.login_signup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.johncarter.thelon.main_screens.LandingPage;
import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.main_screens.LandingPageFoundation;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextView mSignup, mLogin;
    private Button mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        mSignup = (TextView) findViewById(R.id.signup);
        mLogin = (EditText) findViewById(R.id.emailTxt);
        mLoginButton = (Button) findViewById(R.id.button);



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        String name = String.valueOf(mLogin.getText());
        switch (v.getId()){

            case  R.id.signup:
                intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();
                break;
            case R.id.button:
                if(name.equals("volunteer") ) {
                    intent = new Intent(Login.this, LandingPage.class);
//                intent.putExtra("username", mLogin.getText());
                    startActivity(intent);
                    finish();
                    break;
                }
                else if(name.equals("foundation")) {
                    intent = new Intent(Login.this, LandingPageFoundation.class);
                    startActivity(intent);
                    finish();
                    break;
                }
        }
    }
}
