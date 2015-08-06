package com.hkm.r141ez.menu;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.internal.widget.TintImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.hkm.r141ez.R;
import com.hkm.slidingmenulib.advancedtreeview.SmartItem;
import com.hkm.slidingmenulib.layoutdesigns.fragment.treelist;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.List;

/**
 * HKM Invention 2015
 * Created by hesk on 8/7/2015.
 */
public class menuCardM extends treelist<sidemenu, SmartItem> implements View.OnClickListener {
    public static Bundle from(final int e) {
        final Bundle n = new Bundle();
        n.putInt(REQUEST_TYPE, e);
        return n;
    }

    public static menuCardM newInstanceFromMenu() {
        final menuCardM g = new menuCardM();
        g.setArguments(from(LOADMENU));
        return g;
    }

    /**
     * this binding will be excluding the view id of
     * 1)ultimate_recycler_view
     *
     * @param before relative layout
     * @param after  relative layout
     */
    @Override
    protected void expansionBinding(RelativeLayout before, RelativeLayout after) {
        //final View u = LayoutInflater.from(getActivity()).inflate(R.layout.header_layout_menu, null, false);
        // TintImageView im = (TintImageView) u.findViewById(R.id.home);
        //before.addView(u);
        // im.setOnClickListener(this);
        // setBackground(getActivity(), R.color.common_background);
    }

    /**
     * this is better to override it
     *
     * @return the Paint
     */
    @Override
    protected Paint getlinestyle() {
        return getsolid(R.color.divider);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        String[] e = new String[]{"P", "E", "F"};
        // Busprovider.getInstance().post(new Busprovider.menuclass(e, "home"));
    }

    @Override
    protected List<SmartItem> loadCustomMenu() {
        return sidemenu.getPreCodeMenu(getActivity());
    }

    /**
     * load the adapter with the data list
     *
     * @return the adapter with type
     */
    @Override
    protected sidemenu getAdatperWithdata() {
        return new sidemenu(getActivity());
    }

    @Override
    protected void setUltimateRecyclerViewExtra(UltimateRecyclerView ultimateRecyclerView, sidemenu adapter) {

    }


}
