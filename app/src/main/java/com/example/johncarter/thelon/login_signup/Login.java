package com.example.johncarter.thelon.login_signup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johncarter.thelon.admin_side.Foundation_Main;
import com.example.johncarter.thelon.models.Users;
import com.example.johncarter.thelon.models.Volunteer;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.example.johncarter.thelon.admin_side.admin_welcome;
import com.example.johncarter.thelon.main_screens.LandingPage;
import com.example.johncarter.thelon.R;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextView mSignup;
    private Button mLoginButton, mFoundation;
    CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    String TAG = "charles";
    Firebase mrefUsers;
    Firebase mrefVol;
    EditText email;
    Firebase sample;
    DatabaseReference db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(Login.this);
        mCallbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        db = FirebaseDatabase.getInstance().getReference();
        email = (EditText)findViewById(R.id.emailTxt);
        mrefUsers = new Firebase("https://ethelon-33583.firebaseio.com/Users");
        mrefVol = new Firebase("https://ethelon-33583.firebaseio.com/Volunteer");
        sample = new Firebase("https://ethelon-33583.firebaseio.com/");

        if(mrefUsers == null){
            //Toast.makeText(this, "NULL", Toast.LENGTH_SHORT).show();
        }else //Toast.makeText(this, "not null", Toast.LENGTH_SHORT).show();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    startActivity(new Intent(Login.this,LandingPage.class));
                    finish();

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }

            }
        };

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mSignup = (TextView) findViewById(R.id.signup);
        mLoginButton = (Button) findViewById(R.id.button);
        mFoundation = (Button) findViewById(R.id.foundation);
        LoginManager.getInstance().logOut();
        //Initialize custom facebook log in button
        LoginManager.getInstance().registerCallback(
                mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d(TAG, "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "facebook:onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d(TAG, "facebook:onError", exception);
//                        if (exception instanceof FacebookAuthorizationException) {
//                            if (AccessToken.getCurrentAccessToken() != null) {
//                                LoginManager.getInstance().logOut();
//
//                                startActivity(new Intent(Login.this,LandingPage.class));
//                            }
//                        }
                        }
                }
        );
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        //Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            String name = task.getResult().getUser().getDisplayName();
                            String email = task.getResult().getUser().getEmail();
                            String AuthID = task.getResult().getUser().getUid();
                            Users users = new Users(name,"Volunteer",email,AuthID);
                           // Volunteer volunteer = new Volunteer(name,email,"");
                            mrefUsers.child(AuthID).setValue(users);
                        //    mrefVol.child(key).setValue(volunteer);
                            Log.e("kobe","NISUD SA ELSE");
                            Log.e("kobe",""+name);
                        }
                        // ...
                    }
                });

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

                startActivity(new Intent(Login.this,admin_welcome.class));
                  //  startActivity(intent);

                finish();
                break;

            case R.id.foundation:

                LoginManager.getInstance().logInWithReadPermissions(
                        this,
                        Arrays.asList("user_photos", "email", "user_birthday", "public_profile")
                );
                break;
        }
    }
}
