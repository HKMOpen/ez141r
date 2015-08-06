package com.hkm.r141ez.life;

import android.graphics.Color;

import com.hkm.r141ez.R;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrListener;
import com.r0adkll.slidr.model.SlidrPosition;
import com.squareup.picasso.Picasso;


/**
 * HKM Invention 2015
 * Created by hesk on 8/6/2015.
 */
public class LifeCycleApp extends AppBase {

    @Override
    public void onCreate() {
        super.onCreate();
        pic = Picasso.with(this);
        // Save the current Installation to Parse.
        initParseDotCom();
        googleAnalytics();
        initMobileConfiguration();
    }
    private void initMobileConfiguration() {
      /*  if (mMobileConfig == null) {
            mobileconfigready = false;
            try {
                popbeeInterface().mobile_config(new Callback<mobileconfig>() {
                    @Override
                    public void success(mobileconfig mobileconfig, Response response) {
                        mMobileConfig = mobileconfig;
                        mobileconfigready = true;
                        Bust.getInstance().post(mobileconfig);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            } catch (ApiException e) {
                e.printStackTrace();
            }
        } else {
            mobileconfigready = true;
        }*/
    }


    public SlidrConfig getSlidrConfig(final SlidrListener m) {
        SlidrConfig config = new SlidrConfig.Builder()
                .primaryColor(getResources().getColor(R.color.primary_material_light))
                .secondaryColor(getResources().getColor(R.color.second_pref))
                .position(SlidrPosition.LEFT)
                .sensitivity(0.4f)
                .scrimColor(Color.BLACK)
                .scrimStartAlpha(0.8f)
                .scrimEndAlpha(0f)
                .velocityThreshold(50f)
                .distanceThreshold(0.2f)
                .listener(m)
                .build();
        return config;
    }

}
