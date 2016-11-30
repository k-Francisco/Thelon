package com.example.johncarter.thelon.portfolio;

import android.support.v7.widget.CardView;

/**
 * Created by john carter on 12/1/2016.
 */

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
