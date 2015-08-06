package com.hkm.r141ez.menu;

import android.view.View;

import com.hkm.slidingmenulib.advancedtreeview.SmartItem;
import com.hkm.slidingmenulib.advancedtreeview.presnt.slack.Child;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * HKM Invention 2015
 * Created by hesk on 8/7/2015.
 */
public class ChildHolder extends Child<SmartItem, TextView> {
    public ChildHolder(View itemView) {
        super(itemView);
        forceTitleCapitalized(true);
    }

    @Override
    protected void request_api(String[] n, String title) {
        //Busprovider.getInstance().post(new Busprovider.menuclass(n, title));
    }
}