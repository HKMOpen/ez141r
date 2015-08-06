package com.hkm.r141ez.details;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.hkm.r141ez.R;
import com.hkm.r141ez.life.DemoUtil;

import java.util.List;

/**
 * HKM Invention 2015
 * Created by hesk on 8/7/2015.
 */
public class flippage extends Fragment {
    CardContainer mCardContainer;

    public static void addGirls(SimpleCardStackAdapter ad, final List<CardModel> k) {
        for (int i = 0; i < k.size(); i++) {
            final CardModel c = k.get(i);
            c.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
                @Override
                public void onLike() {
                    Log.d("Swipeable Card", c.getTitle() + "I liked it");

                }

                @Override
                public void onDislike() {
                    Log.d("Swipeable Card", c.getTitle() + "I did not liked it");
                }
            });
            ad.add(c);
        }
    }

    private void initBinding(View view) {
        mCardContainer = (CardContainer) view.findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Ordered);
        mCardContainer.setOrientation(Orientations.Orientation.Disordered);
    }

    private void dataset() {
        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(getActivity());
        addGirls(adapter, DemoUtil.mm(getActivity()));
        mCardContainer.setAdapter(adapter);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sexy_flip, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initBinding(view);
        dataset();
    }

}
