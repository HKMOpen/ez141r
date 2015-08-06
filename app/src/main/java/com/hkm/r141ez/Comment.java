package com.hkm.r141ez;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.hkm.ezwebview.Util.Fx9C;
import com.hkm.ezwebview.Util.In32;
import com.hkm.r141ez.details.commentbox;
import com.hkm.r141ez.life.LifeCycleApp;
import com.hkm.slidingmenulib.layoutdesigns.singleDetailPost;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrListener;

/**
 * Created by hesk on 23/7/15.
 */
public class Comment extends singleDetailPost<commentbox> implements SlidrListener {

    public static Bundle fbBun(final @StringRes int title, final String id_comment) {
        final Bundle n = new Bundle();
        n.putInt(Method, REQUEST_METHOD_FULL_URL);
        n.putString(requestURL, id_comment);
        return n;
    }

    @Override
    protected void loadPageWithFullURL(String url) {
        Log.d("ons", url);
    }


    @Override
    protected void loadPageWithPID(long pid) {

    }

    private commentbox mcomme;

    /**
     * setting the first initial fragment at the beginning
     *
     * @return generic type fragment
     * @throws Exception the exception for the wrongs
     */
    @Override
    protected commentbox getInitFragment() throws Exception {
        return mcomme = commentbox.B(commentbox.fbIntent(R.string.lifestyle, url));
    }

    @Override
    protected void onMenuItemSelected(@IdRes int Id) {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        LifeCycleApp app = (LifeCycleApp) getApplication();
        Slidr.attach(this, app.getSlidrConfig(this));
        startIntentArgument();
        super.onCreate(savedInstanceState);
        mcomme.complete();
    }

    /**
     * the location to setup and configure the toolbar widget under AppCompat V7
     *
     * @param v7 Toolbar object
     */
    @Override
    protected void configToolBar(Toolbar v7) {
        super.configToolBar(v7);
        v7.setNavigationIcon(R.drawable.arrow_left);
        v7.setBackgroundResource(R.drawable.actionbar_bg_white_greyline);
    }

    @Override
    public void onSlideStateChanged(int i) {

    }

    @Override
    public void onSlideChange(float v) {

    }

    @Override
    public void onSlideOpened() {

    }

    @Override
    public void onSlideClosed() {

    }
}
