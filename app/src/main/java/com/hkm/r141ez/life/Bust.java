package com.hkm.r141ez.life;

import com.squareup.otto.Bus;

/**
 * Created by hesk on 14/7/15.
 */
public class Bust {
    private static final Bus BUS = new Bus();
    public static Bus getInstance() {
        return BUS;
    }
    private Bust() {

    }


    public static class booleanclass {
        private boolean enabled;

        public booleanclass(boolean statusEnabled) {
            this.enabled = statusEnabled;
        }

        public boolean getEnabled() {
            return this.enabled;
        }
    }
}
