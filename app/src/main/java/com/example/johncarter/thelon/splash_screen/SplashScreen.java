package com.example.johncarter.thelon.splash_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.login_signup.Login;

import static com.example.johncarter.thelon.R.id.splash_dotright;

public class SplashScreen extends Activity {

    ImageView mLetterE, mDotLeft, mDotRight, mSlogan;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        init();
        startAnimation();
    }

    private void startAnimation() {

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        mLetterE.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                mSlogan.startAnimation(animation);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                mDotLeft.animate().scaleX(1).scaleY(1).setDuration(100).start();
                mDotLeft.setScaleX(1);
                mDotLeft.setScaleY(1);
                mDotRight.animate().scaleY(1).scaleX(1).setDuration(100).setStartDelay(200).start();


                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                mSlogan.startAnimation(animation);
                mDotLeft.startAnimation(animation);
                mDotRight.startAnimation(animation);
                mLetterE.startAnimation(animation);

                mSlogan.setVisibility(View.GONE);
                mDotLeft.setVisibility(View.GONE);
                mDotRight.setVisibility(View.GONE);
                mLetterE.setVisibility(View.GONE);

                Thread splashThread = new Thread(){

                    @Override
                    public void run() {
                        try {
                            int waited = 0;
                            while(waited < 2200){
                                sleep(100);
                                waited+=100;
                            }
                            Intent intent = new Intent(SplashScreen.this, Login.class);
                            startActivity(intent);
                            SplashScreen.this.finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            SplashScreen.this.finish();
                        }
                    }
                };
                splashThread.start();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void init() {

        mLetterE = (ImageView) findViewById(R.id.splash_e);
        mDotLeft = (ImageView) findViewById(R.id.splash_dotleft);
        mDotRight = (ImageView) findViewById(splash_dotright);
        mSlogan = (ImageView) findViewById(R.id.splash_slogan);
    }
}
