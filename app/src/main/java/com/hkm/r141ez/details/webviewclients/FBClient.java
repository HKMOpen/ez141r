package com.hkm.r141ez.details.webviewclients;

import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.hkm.r141ez.details.webviewleakfix.PreventLeakClient;


/**
 * Created by hesk on 23/7/15.
 */
public class FBClient<Main extends AppCompatActivity> extends PreventLeakClient {

    private String loginCookie;

    private WebView mWebView;
    public static String TAG = "hypebeastPathsWatcher";
    private String authCallback = "...";

    public FBClient(Main context, WebView webview) {
        super(context);
        mWebView = webview;
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        // CookieManager cookieManager = CookieManager.getInstance();
        //loginCookie = cookieManager.getCookie(url);
    }

}
