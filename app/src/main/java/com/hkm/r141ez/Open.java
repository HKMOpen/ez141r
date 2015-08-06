package com.hkm.r141ez;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.hkm.r141ez.details.flippage;
import com.hkm.r141ez.menu.menuCardM;
import com.hkm.r141ez.menu.sidemenu;
import com.hkm.slidingmenulib.gestured.SlidingMenu;
import com.hkm.slidingmenulib.layoutdesigns.app.SlidingAppCompactActivity;

/**
 * HKM Invention 2015
 * Created by hesk on 8/6/2015.
 */
public class Open extends SlidingAppCompactActivity<Fragment> {

    @Override
    protected menuCardM getFirstMenuFragment() {
        return new menuCardM();
    }

    @Override
    protected void customizeSlideMenuEdge(SlidingMenu sm) {
        sm.setFadeDegree(0.35f);
        sm.setMode(SlidingMenu.LEFT);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        sm.setBehindScrollScale(0.5f);
        sm.setFadeDegree(0.34f);
        sm.setBehindWidth(840);
        sm.requestLayout();
        sm.invalidate();
    }

    @Override
    protected flippage getInitFragment() {
        return new flippage();
    }

}
