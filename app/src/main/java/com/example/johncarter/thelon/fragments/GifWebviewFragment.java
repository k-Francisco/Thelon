package com.example.johncarter.thelon.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.example.johncarter.thelon.R;

/**
 * Created by dell on 12/1/2016.
 */

public class GifWebviewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;

        rootView = inflater.inflate(R.layout.web_view,container,false);
            //GifWebView view = new GifWebView(rootView.getContext(), "file:///android_asset/starboyzz.gif");
            WebView wv = (WebView) rootView.findViewById(R.id.webby);
            wv.loadUrl("file:///android_asset/starboyzz.gif");


        return rootView;
    }
}
