package com.example.johncarter.thelon.home_details;

import android.app.FragmentManager;
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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.ReferVolunteerFragment;
import com.example.johncarter.thelon.admin_side.StaggeredAscPicsFragment;
import com.example.johncarter.thelon.admin_side.VolunteersInDetailsFragment;
import com.example.johncarter.thelon.fragments.Home_Details_Text;

import butterknife.ButterKnife;
import ru.shmakinv.android.material.widget.GpCollapsingToolbar;

public class home_details extends AppCompatActivity {

    ImageView joinBtn;
    ImageView refer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_details2);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.parseColor("#EE2A1B"));

        joinBtn = (ImageView) findViewById(R.id.joinBtn);

        refer = (ImageView)findViewById(R.id.referBtn);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.volunteersFrame, new VolunteersInDetailsFragment()).commit();
        fm.beginTransaction().replace(R.id.ascPicsFrame, new StaggeredAscPicsFragment()).commit();
        fm.beginTransaction().replace(R.id.commentsFrame, new CommentsFragment()).commit();

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinBtn.setImageResource(R.drawable.ic_heart_red);
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
