package com.hkm.r141ez.life;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import com.hkm.r141ez.BuildConfig;
import com.squareup.picasso.Picasso;

import java.net.CookieManager;


/**
 * Created by hesk on 3/7/15.
 */
public abstract class AppBase extends Application {
    private static CookieManager cookieManager;
    public static GoogleAnalytics analytics;
    public static Tracker tracker;
    public static CookieManager getHBCookieMgr() {
        return cookieManager;
    }
    protected Picasso pic;

    protected void initParseDotCom() {
        //CookieHandler.setDefault(cookieManager);
        // Enable Crash Reporting
       // ParseCrashReporting.enable(this);
        // ENABLE PARSE IN HERE
        // Parse.enableLocalDatastore(this);
        // Enable and initialize the parse application
     //   Parse.initialize(this, BuildConfig.PARSE_APPLICATION_ID, BuildConfig.PARSE_CLIENT_KEY);
     //   ParseInstallation.getCurrentInstallation().saveInBackground();
        // When users indicate they are Giants fans, we subscribe them to that channel.
       /* ParsePush.subscribeInBackground("testingchannel", new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                        } else {
                            Log.e("com.parse.push", "failed to subscribe for push", e);
                        }
                    }
                }
        );*/

    }

    public Picasso getInstancePicasso() {
        return pic;
    }

    public Tracker getTracker() {
        return tracker;
    }


    protected void googleAnalytics() {
        analytics = GoogleAnalytics.getInstance(this);
        analytics.setLocalDispatchPeriod(1800);
        tracker = analytics.newTracker(BuildConfig.GOOGLE_TRACKER); // Replace with actual tracker/property Id
        tracker.enableExceptionReporting(true);
        tracker.enableAdvertisingIdCollection(false);
        tracker.enableAutoActivityTracking(true);
    }

    protected void initializeDisQus() {
        try {
            final SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
