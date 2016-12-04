package com.example.johncarter.thelon.portfolio;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.FoundationActivitiesAdapter;
import com.example.johncarter.thelon.home_details.home_details;
import com.example.johncarter.thelon.home_details.home_details_joined;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Portfolio extends ActionBarActivity {

    @Bind(R.id.nav_toolbar)
    Toolbar toolbar;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);


//        textView = (TextView) findViewById(R.id.view_more);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Portfolio.this, home_details_joined.class);
//
//                Pair<View, String> p1 = Pair.create(findViewById(R.id.portfolio_host), "portfolioHost");
//                Pair<View, String> p2 = Pair.create(findViewById(R.id.portfolio_ratingbar), "portfolio");
//                Pair<View, String> p3 = Pair.create(findViewById(R.id.portfolio_image), "home_details_trans");
//                Pair<View, String> p4 = Pair.create(findViewById(R.id.portfolio_title), "activity_title");
//
//
//                ActivityOptionsCompat options = ActivityOptionsCompat
//                        .makeSceneTransitionAnimation(Portfolio.this, p1, p2, p3, p4);
//                startActivity(intent, options.toBundle());
//            }
//        });
//
//        window = getWindow();
//        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_right);
//        window.setEnterTransition(transition);
//        window.setExitTransition(transition);
//
//
//        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setTitle("Portfolio");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        recyclerView = (RecyclerView) this.findViewById(R.id.portfolio_list);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        layoutManager = linearLayoutManager;
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new portfolioAdapter2();
//        recyclerView.setAdapter(adapter);
//
//        mViewPager = (ViewPager) findViewById(R.id.viewPager);
//        mViewPager.setPageMargin(50);
//        mCardAdapter = new CardPagerAdapter(this,this);
//        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
//        mCardShadowTransformer.enableScaling(true);
//
//
//
//        mViewPager.setAdapter(mCardAdapter);
//        mViewPager.setPageTransformer(false, mCardShadowTransformer);
//        mViewPager.setOffscreenPageLimit(3);
//    }
//
//
//    public void show(boolean isTouched){
//        relative = (RelativeLayout) findViewById(R.id.popup);
//        if (!isTouched) {
//
//            relative.animate()
//                    .setInterpolator(new FastOutLinearInInterpolator())
//                    .setDuration(200)
//                    .scaleX(1)
//                    .scaleY(1)
//                    .start();
//
//        } else {
//            relative.animate()
//                    .setInterpolator(new FastOutLinearInInterpolator())
//                    .setDuration(200)
//                    .scaleX(0)
//                    .scaleY(0)
//                    .start();
//        }

    }
}
