package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
/**
 * Created by Acer on 04/12/2016.
 */

public class AttendaceCheckinig extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private String actKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
        actKey = getIntent().getStringExtra("key");

    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        if(result.getText().equals(actKey)) {
            finish();
            startActivity(new Intent(this, AttendanceSuccess.class));
        }
        else
            Toast.makeText(this, "Invalid QR Code!", Toast.LENGTH_SHORT).show();
    }
}
