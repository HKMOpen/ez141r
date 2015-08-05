package com.hkm.r141ez.life;

import android.os.Build;

/**
 * Android App settings
 * Created by hesk on 2/2/15.
 */
public class Config {


    public final static boolean enableSampleData = false;
    public final static int pageLimit = 12;
    public static final String base_tc = "http://cn.hypebeast.com/t";
    public static final String base_cn = "http://cn.hypebeast.com";
    public static final String base_jp = "http://jp.hypebeast.com";
    public static final String base_en = "http://hypebeast.com";
    public static final String menuendpoint = "http://hypebeast.com/api/mobile-app-config";
    /**
     * the specific page view from the browser or from other intents
     */
    public static final String action_name_page_view = "com.hb.editorial.SINGLE_PAGE_VIEW";

    public static class setting {
        public static int show_share_items = 44;
        public static int single_page_items = 18;
        public static int APIversion = 2;
        public static String wv_usergent = "HypebeastEditorial/1.0";
        public static String useragent = "HypebeastEditorial/1.0 Android" + Build.VERSION.SDK_INT;
        public static final float PORTION_CONFIG = 3f / 2f;
        //   public static final float PORTION_CONFIG = 11f / 10f;
        public static final int LANG_JP = 2, LANG_CN = 1, LANG_TC = 3, LANG_EN = 0;
    }

    public static class urlmask {
        public static final String u1 = "";
        public static final String u2 = "";
        public static final String u3 = "";
    }

    public static float horizontal_image = 2.058f;
    /**
     * using hesk.kam@101medialab.com    @parse.com
     */
    public static final String DFP_INTER_ID = "/1015938/Hypebeast_Interstital_320x480";
    public static final String DFP_BANNER_UNIT_ID = "/1015938/Hypebeast_App_320x50";
    public static final String DFP_LIST_UNIT_ID = "/1015938/Hypebeast_App_List";

    public static class menu {
        public static String[] fashion = new String[]{
                "lookbook", "category/fashion/lookbook",
                "runway", "category/fashion/runway-fashion",
                "streetsnaps", "category/fashion/streetsnaps",
                "trends", "category/fashion/trends-fashion",
        };
        public static String[] accessories = new String[]{
                "handbags", "category/accessories/handbags",
                "jewelry", "category/accessories/jewelry",
                "shoes", "category/accessories/shoes",
                "watches", "category/accessories/watches",
        };
        public static String[] beauty = new String[]{
                "make up", "category/beauty/make-up",
                "perfumes", "category/beauty/perfumes",
        };
        public static String[] celebrities = new String[]{
                "celebrities", "category/celebrities",
        };
        public static String[] wedding = new String[]{
                "wedding", "category/wedding",
        };
        public static String[] lifestyle = new String[]{
                "food", "category/lifestyle/food",
                "gadgets", "category/lifestyle/gadgets",
                "health", "category/lifestyle/health",
                "home and living", "category/lifestyle/home-and-living",
                "travel", "category/lifestyle/travel",
        };
    }


}
