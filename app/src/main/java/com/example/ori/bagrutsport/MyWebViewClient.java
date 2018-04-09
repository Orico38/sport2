package com.example.ori.bagrutsport;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Ori on 4/7/2018.
 */

class MyWebViewClient extends WebViewClient {
    public boolean shouldOverrideUrlloading(WebView view, String url) {
        view.loadUrl(url);
        return true;

    }
}
