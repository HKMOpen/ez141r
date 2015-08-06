package com.hkm.r141ez.life;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.andtinder.model.CardModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * HKM Invention 2015
 * Created by hesk on 8/7/2015.
 */
public class DemoUtil {

    private static final String[] namelist = new String[]{
            "Uni",
            "Yuki",
            "Voc",
            "丹妮",
            "Rachel",
            "Onami",
            "Zero"
    };

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static List<CardModel> mm(Context context) {
        final List<CardModel> lm = new ArrayList<>();
        final AssetManager assetManager = context.getAssets();
        final Picasso p = Picasso.with(context);
        try {
            final String[] filelistInSubfolder = assetManager.list("demo");
            if (filelistInSubfolder == null) {
                // dir does not exist or is not a directory
            } else {
                for (int i = 0; i < filelistInSubfolder.length; i++) {
                    // Get filename of file or directory
                    final String persona = namelist[randInt(0, namelist.length - 1)];
                    final String fileNameh = filelistInSubfolder[i];
                    Handler uiHandler = new Handler(Looper.getMainLooper());
                    uiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                final CardModel card = new CardModel(persona, "Fexxxf", bitmap);
                                lm.add(card);
                                p.load("file:///android_asset/demo/" + fileNameh).;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lm;
    }

}
