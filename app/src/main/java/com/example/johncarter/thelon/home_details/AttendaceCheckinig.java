package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
/**
 * Created by Acer on 04/12/2016.
 */

public class AttendaceCheckinig extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private String actKey;
    private Firebase activityAfter;
    FirebaseAuth auth;
    String userID;
    Firebase dummyAct;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        auth = FirebaseAuth.getInstance();
        dummyAct = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesDummy");
        activityAfter = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesAfter");
        mScannerView = new ZXingScannerView(this);
        actKey = getIntent().getStringExtra("key");
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        if(result.getText().equals(actKey)) {

            userID = auth.getCurrentUser().getUid();
            userName = auth.getCurrentUser().getDisplayName();
            activityAfter.child(actKey).child(userID).setValue(userName);
            //dummyAct.child(actKey).child(userID).setValue(userName);

            finish();
            startActivity(new Intent(this, AttendanceSuccess.class).putExtra("key",actKey));

        }
        else
            Toast.makeText(this, "Invalid QR Code!", Toast.LENGTH_SHORT).show();
    }
}
