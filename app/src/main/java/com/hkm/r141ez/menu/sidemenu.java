package com.hkm.r141ez.menu;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hkm.r141ez.R;
import com.hkm.slidingmenulib.advancedtreeview.SmartItem;
import com.hkm.slidingmenulib.advancedtreeview.presnt.slack.customadapterhb;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * HKM Invention 2015
 * Created by hesk on 8/7/2015.
 */
public class sidemenu extends customadapterhb<SmartItem, CarryHolder, ChildHolder> {


    public sidemenu(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResChild() {
        return R.layout.exp_child;
    }

    @Override
    protected int getLayoutResParent() {
        return R.layout.exp_parent;
    }

    private static List<SmartItem> mainSmallList(final String[] list) {
        final List<SmartItem> items = new ArrayList<SmartItem>();

        for (int i = 0; i <= list.length - 2; i = i + 2) {
            items.add(SmartItem.child(list[i], list[i + 1]));
        }

        return items;
    }

    public static List<SmartItem> getPreCodeMenu(Context t) {
        List<SmartItem> e = new ArrayList<SmartItem>();
      /*  e.add(SmartItem.parent(ef, R.string.fashion, "open", mainSmallList(Config.menu.fashion)));
        e.add(SmartItem.parent(ef, R.string.accessories, "open", mainSmallList(Config.menu.accessories)));
        e.add(SmartItem.parent(ef, R.string.beauty, "open", mainSmallList(Config.menu.beauty)));
        e.add(SmartItem.child(Config.menu.celebrities[0], Config.menu.celebrities[1]));
        e.add(SmartItem.child(Config.menu.wedding[0], Config.menu.wedding[1]));
        e.add(SmartItem.parent(ef, R.string.lifestyle, "open", mainSmallList(Config.menu.lifestyle)));*/


        e.add(SmartItem.child(t, R.string.fashion, "category/fashion"));
        e.add(SmartItem.child(t, R.string.accessories, "category/accessories"));
        e.add(SmartItem.child(t, R.string.beauty, "category/beauty"));
        e.add(SmartItem.child(t, R.string.cele, "category/celebrities"));
        e.add(SmartItem.child(t, R.string.weddin, "category/wedding"));
        e.add(SmartItem.child(t, R.string.lifestyle, "category/lifestyle"));
        return e;
    }

    /**
     * please do work on this if the custom object is true
     *
     * @param childview the inflated view
     * @return the actual child holder
     */
    @Override
    protected ChildHolder iniCustomChildHolder(View childview) {
        return new ChildHolder(childview);
    }

    /**
     * please do work on this id the custom object is true
     *
     * @param parentview the inflated view
     * @return the actual parent holder
     */
    @Override
    protected CarryHolder iniCustomParentHolder(View parentview) {
        return new CarryHolder(parentview);
    }


    @Override
    protected List<SmartItem> getChildrenByPath(String path, int depth, final int pos) {
        return getSet().get(pos).getChildren();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view) {
        return new UltimateRecyclerviewViewHolder(view);
    }
}
