package com.hkm.r141ez.details;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;

import com.hkm.r141ez.R;
import com.hkm.r141ez.details.webviewclients.ChromeLoader;
import com.hkm.r141ez.details.webviewclients.FBClient;
import com.hkm.r141ez.details.webviewleakfix.NonLeakingWebView;
import com.hkm.r141ez.life.EZUtil;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;


/**
 * Created by hesk on 23/7/15.
 */
public abstract class WebviewCommentBox extends Fragment {
    public static final String
            FRAGMENTTITLE_RESID = "title_resid",
            COMMENT_BOX_ID = "comment_box_identification",
            REQUEST_TYPE = "request_type";
    public static final int FB_COMMENT = 9019;
    public static final int SINA_COMMENT = 9016;


    private NonLeakingWebView block;
    private CircleProgressBar betterCircleBar;
    private RelativeLayout framer;

    protected abstract int commentbox_layout_id();

    @SuppressLint("ResourceAsColor")
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected void initBinding(View v) {
        betterCircleBar = (CircleProgressBar) v.findViewById(R.id.simple_process);
        block = (NonLeakingWebView) v.findViewById(R.id.content_block);
        framer = (RelativeLayout) v.findViewById(R.id.simple_frame);
    }

    private void killWebView(NonLeakingWebView mWebView) {
        //http://stackoverflow.com/questions/3815090/webview-and-html5-video
        if (mWebView.getVisibility() == View.GONE) {
            mWebView.loadUrl("about:blank");
            mWebView.destroy();
        }
    }


    @SuppressLint("SetJavaScriptEnabled")
    protected void setup_commentbox(final String url_id) {
        block.setWebChromeClient(new ChromeLoader(betterCircleBar));
        block.setWebViewClient(new FBClient<AppCompatActivity>((AppCompatActivity) getActivity(), block));
        //  block.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // block.getSettings().setSupportMultipleWindows(true);
        block.getSettings().setPluginState(WebSettings.PluginState.ON);
        block.getSettings().setPluginState(WebSettings.PluginState.ON_DEMAND);
        block.getSettings().setJavaScriptEnabled(true);
        block.getSettings().setAppCacheEnabled(true);
        block.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        block.loadUrl(EZUtil.fbCommentbox(url_id));
        // Log.d("webview", ur);
        block.setVisibility(View.VISIBLE);
        EZUtil.startToReveal(framer, 1500);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(commentbox_layout_id(), container, false);
    }


    protected void completeloading() {
        ViewCompat.animate(betterCircleBar).alpha(0f).withEndAction(new Runnable() {
            @Override
            public void run() {
                betterCircleBar.setVisibility(View.GONE);
            }
        });
    }

    public void kill() {
        killWebView(block);
    }

}
