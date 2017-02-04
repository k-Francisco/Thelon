package com.example.johncarter.thelon.home_tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.johncarter.thelon.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Acer on 05/12/2016.
 */

public class InfoActivity extends AppCompatActivity {

    private static final String EXTRA_TRAVEL = "EXTRA_TRAVEL";
    static final String EXTRA_PHOTO = "EXTRA_PHOTO";
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.title)
    TextView title;

    public static Intent newInstance(Context context, Travel travel, PhotoReference photoReference) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_TRAVEL, travel);
       // intent.putExtra(EXTRA_PHOTO, photoReference);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        Travel travel = getIntent().getParcelableExtra(EXTRA_TRAVEL);
        PhotoReference photoReference = getIntent().getParcelableExtra(EXTRA_PHOTO);
        if (travel != null) {
          //  image.setImageResource(travel.getImage());
           // Glide.with(this).using(new FirebaseImageLoader()).load(travel.getImage()).into(image);
            title.setText(travel.getName());
        }
    }
}
