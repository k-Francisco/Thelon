package com.example.johncarter.thelon.leaderboard_tab;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by dell on 12/1/2016.
 */

public class GifWebview extends WebView{

    public GifWebview(Context context, String path){
        super(context);
        loadUrl(path);
    }
}
