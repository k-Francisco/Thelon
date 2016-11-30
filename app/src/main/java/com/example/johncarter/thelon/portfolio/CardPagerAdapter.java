package com.example.johncarter.thelon.portfolio;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;

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

    public CardPagerAdapter(Portfolio mainActivity) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        isMoved = false;
        main = mainActivity;


        for (int i = 0; i < 5; i++) {
            mData.add("");
            mViews.add(null);
        }
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.portfolio_card_layout, container, false);
        container.addView(view);
        final CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0){

            mBaseElevation = cardView.getCardElevation();
        }


        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isMoved){
                    main.show(isMoved);
                    cardView.animate()
                            .setInterpolator(new FastOutLinearInInterpolator())
                            .setDuration(200)
                            .setStartDelay(100)
                            .translationY(-25)
                            .start();
                    isMoved = true;
                }else {
                    main.show(isMoved);
                    cardView.animate()
                            .setInterpolator(new FastOutLinearInInterpolator())
                            .setDuration(200)
                            .setStartDelay(100)
                            .translationY(0)
                            .start();
                    isMoved = false;
                }
            }
        });
        mViews.set(position, cardView);

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
