package com.example.johncarter.thelon.home_details;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.ReferVolunteerFragment;
import com.example.johncarter.thelon.admin_side.StaggeredAscPicsFragment;
import com.example.johncarter.thelon.admin_side.VolunteersInDetailsFragment;
import com.example.johncarter.thelon.fragments.Home_Details_Text;
import com.firebase.client.Firebase;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import butterknife.ButterKnife;
import ru.shmakinv.android.material.widget.GpCollapsingToolbar;

public class home_details extends AppCompatActivity {

    ImageView joinBtn;
    ImageView refer;
    TextView occupation;
    TextView contact;
    TextView location;
    TextView dateAndTime;
    TextView name;
    TextView foundation;
    ImageView image;
    String locationText;
    String occupationText;
    String contactText;
    String dateText;
    String nameF;
    String found;
    String url;
    StorageReference storageReference;
    String key;

    Firebase activityAttendeesBefore;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_details2);
        Firebase.setAndroidContext(this);

        activityAttendeesBefore = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesBefore");
        auth = FirebaseAuth.getInstance();
        Window window = this.getWindow();
        storageReference = FirebaseStorage.getInstance().getReference();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.parseColor("#EE2A1B"));
        name = (TextView)findViewById(R.id.label1);
        foundation = (TextView)findViewById(R.id.label2);
        occupation = (TextView)findViewById(R.id.occupation);
        contact = (TextView)findViewById(R.id.contacts);
        location = (TextView)findViewById(R.id.location);
        dateAndTime = (TextView)findViewById(R.id.dateAndtTime);
        image = (ImageView)findViewById(R.id.im);
        joinBtn = (ImageView) findViewById(R.id.joinBtn);

        Intent in = getIntent();
            locationText = in.getStringExtra("location");
            occupationText = in.getStringExtra("occupation");
            contactText = in.getStringExtra("contactNumberAndPerson");
             dateText = in.getStringExtra("dateAndtime");
            nameF = in.getStringExtra("name");
            found = in.getStringExtra("foundation");
            url = in.getStringExtra("photo");
            key = in.getStringExtra("key");


        occupation.setText(occupationText);
        contact.setText(contactText);
        location.setText(locationText);
        dateAndTime.setText(dateText);
        name.setText(nameF);
        foundation.setText(found);
        Log.e("home","name = "+in.getStringExtra("name")+" found "+in.getStringExtra("foundation"));
        StorageReference st = storageReference.child("ActivityPhotos").child(key).child(url);
        Glide.with(this).using(new FirebaseImageLoader()).load(st).into(image);


        refer = (ImageView)findViewById(R.id.referBtn);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.volunteersFrame, new VolunteersInDetailsFragment()).commit();
        fm.beginTransaction().replace(R.id.ascPicsFrame, new StaggeredAscPicsFragment()).commit();
        fm.beginTransaction().replace(R.id.commentsFrame, new CommentsFragment()).commit();

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinBtn.setImageResource(R.drawable.ic_heart_red);
                String userID =  auth.getCurrentUser().getUid();
                String userName = auth.getCurrentUser().getDisplayName();

                activityAttendeesBefore.child(key).child(userID).setValue(userName);

                Snackbar.make(v, "Successfully joined event!",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 2000);

            }
        });
        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                ReferVolunteerFragment ref = new ReferVolunteerFragment();
                ref.show(fm,"dialog");
            }
        });




//        Slide slide = new Slide();
//        slide.setInterpolator(new DecelerateInterpolator());
//        slide.addTarget(R.id.actTitle);
//        slide.addTarget(R.id.hostpic);
//        slide.addTarget(R.id.ratingBar);
//        slide.addTarget(R.id.tab_menu);
//        getWindow().setEnterTransition(slide);
//        getWindow().setExitTransition(slide);
    }
}
