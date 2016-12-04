package com.example.johncarter.thelon.portfolio;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john carter on 12/1/2016.
 */

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<String> mData;
    private float mBaseElevation;
    private boolean isMoved;
    private Portfolio main;
    private Context context;

    public CardPagerAdapter(Portfolio mainActivity, Context context) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        isMoved = false;
        main = mainActivity;
        this.context = context;


        for (int i = 0; i < 5; i++) {
            mData.add("");
            mViews.add(null);
        }
    }



    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.portfolio_card_layout2, container, false);
        container.addView(view);
        final CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0){

            mBaseElevation = cardView.getCardElevation();
        }

        mViews.set(position, cardView);
        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!isMoved){
//                    main.show(isMoved);
//                    cardView.animate()
//                            .setInterpolator(new FastOutLinearInInterpolator())
//                            .setDuration(200)
//                            .setStartDelay(100)
//                            .translationY(-25)
//                            .start();
//                    isMoved = true;
//                }else {
//                    main.show(isMoved);
//                    cardView.animate()
//                            .setInterpolator(new FastOutLinearInInterpolator())
//                            .setDuration(200)
//                            .setStartDelay(100)
//                            .translationY(0)
//                            .start();
//                    isMoved = false;
//                }
            }
        });



        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
