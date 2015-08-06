package com.hkm.r141ez.menu;

import android.view.View;

import com.hkm.slidingmenulib.advancedtreeview.SmartItem;
import com.hkm.slidingmenulib.advancedtreeview.presnt.slack.Parent;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * HKM Invention 2015
 * Created by hesk on 8/7/2015.
 */
public class CarryHolder extends Parent<SmartItem, TextView> {

    public CarryHolder(View itemView) {
        super(itemView);
        setNotifcationFieldEnabled(false);
        forceTitleCapitalized(true);
    }


}