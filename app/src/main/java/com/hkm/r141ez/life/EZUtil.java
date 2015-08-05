package com.hkm.r141ez.life;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RawRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hkm.r141ez.Comment;
import com.hkm.r141ez.R;
import com.hkm.slider.SliderLayout;
import com.hkm.slidingmenulib.Util.Utils;
import com.neopixl.pixlui.components.textview.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by hesk on 3/7/15.
 */
public class EZUtil {
    private static String APP_INTENT_TITLE = "title";
    private static String APP_INTENT_URI = "uri";

    /**
     * start the new activities
     *
     * @param packageName the package application id
     * @param url         the url to start from
     * @param title       the title to send as extra information
     */
    public static void startNewActivity(final String packageName, final String url, final String title, final Context activity) {
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
        /* We found the activity now start the activity */
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle b = new Bundle();
            b.putString(APP_INTENT_URI, url);
            b.putString(APP_INTENT_TITLE, title);
            intent.putExtras(b);
            activity.startActivity(intent);
        } else {
        /* Bring user to the market or let them choose an app? */
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            activity.startActivity(intent);
        }
    }

    /**
     * start the intent from the list view
     *
     * @param url      the url in full path
     * @param activity the activity
     */
    public static void startFeedList(final String url, final Activity activity) {
        Bundle conData = new Bundle();
        // conData.putString(NgMainS.KEYURL, url);
        Intent intent = new Intent();
        intent.putExtras(conData);
        // activity.setResult(NgMainS.RETURN_WITH_NEW_FEED_URL, intent);
        // activity.finish();
    }

    /**
     * 07-30 11:42:03.854    6718-6718/com.popbee.editorial E/AndroidRuntime﹕ FATAL EXCEPTION: main
     * Process: com.popbee.editorial, PID: 6718
     * java.lang.RuntimeException: Unable to pause activity {com.popbee.editorial/com.popbee.Single}: java.lang.NullPointerException: Attempt to invoke virtual method 'int android.view.ViewGroup.getVisibility()' on a null object reference
     * at android.app.ActivityThread.performPauseActivity(ActivityThread.java:3254)
     * at android.app.ActivityThread.performPauseActivity(ActivityThread.java:3213)
     * at android.app.ActivityThread.handlePauseActivity(ActivityThread.java:3188)
     * at android.app.ActivityThread.access$1100(ActivityThread.java:147)
     * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1307)
     * at android.os.Handler.dispatchMessage(Handler.java:102)
     * at android.os.Looper.loop(Looper.java:135)
     * at android.app.ActivityThread.main(ActivityThread.java:5254)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at java.lang.reflect.Method.invoke(Method.java:372)
     * at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:898)
     * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:693)
     * Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'int android.view.ViewGroup.getVisibility()' on a null object reference
     * at com.popbee.life.EZUtil.hideSlider(EZUtil.java:87)
     * at com.popbee.pages.detail.detailbse.hidevideo(detailbse.java:141)
     * at com.popbee.pages.detail.detailbse.killvideo(detailbse.java:229)
     * at com.popbee.Single.onPause(Single.java:204)
     * at android.app.Activity.performPause(Activity.java:6044)
     * at android.app.Instrumentation.callActivityOnPause(Instrumentation.java:1294)
     * at android.app.ActivityThread.performPauseActivity(ActivityThread.java:3240)
     *             at android.app.ActivityThread.performPauseActivity(ActivityThread.java:3213)
     *             at android.app.ActivityThread.handlePauseActivity(ActivityThread.java:3188)
     *             at android.app.ActivityThread.access$1100(ActivityThread.java:147)
     *             at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1307)
     *             at android.os.Handler.dispatchMessage(Handler.java:102)
     *             at android.os.Looper.loop(Looper.java:135)
     *             at android.app.ActivityThread.main(ActivityThread.java:5254)
     *             at java.lang.reflect.Method.invoke(Native Method)
     *             at java.lang.reflect.Method.invoke(Method.java:372)
     *
     * @param view the view object
     * @return yes or no
     */
    public static boolean hideSlider(final Object view) {
        boolean killable = false;
        if (view == null) return killable;
        try {
            if (view instanceof RelativeLayout) {
                RelativeLayout v = (RelativeLayout) view;
                killable = v.getVisibility() != View.GONE;
                v.setVisibility(View.GONE);
            } else if (view instanceof SliderLayout) {
                SliderLayout v = (SliderLayout) view;
                killable = v.getVisibility() != View.GONE;
                v.setVisibility(View.GONE);
            }
        } catch (Exception e) {
        }
        return killable;
    }

    public static void startToReveal(final ViewGroup view, final int timeinit) {
        final Handler h = new Handler();
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0f);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.animate().alpha(1f);
            }
        }, timeinit);
    }



    public static void easyCallShareProvoider(Context ctx, final String content) {
        String nohtml = content.replaceAll("\\<.*?>", "");
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, nohtml);
        sendIntent.setType("text/plain");
        ctx.startActivity(sendIntent);
    }

    public static void easyFBCommentary(Context ctx, final String fb_comment_box_id) {
        Intent commentIntent = new Intent(ctx, Comment.class);
        commentIntent.putExtras(Comment.fbBun(R.string.lifestyle, fb_comment_box_id));
        ctx.startActivity(commentIntent);
    }

    /**
     * start the single page with full route URL
     *
     * @param route the full url
     * @param ctx   the resource context
     */
    public static void routeSinglePage(String route, Context ctx) {
       // Utils.routeSinglePage(route, ctx, Single.class);
    }

    /**
     * start the single page with post id
     *
     * @param pid the post ID
     * @param ctx the resource context
     */
    public static void routeSinglePage(long pid, Context ctx) {
       // Utils.routeSinglePage(pid, ctx, Single.class);
    }

    /**
     * start the application in browser to see the url or choose by other application to view this uri
     *
     * @param url      in full path for url
     * @param activity the activity
     */
    public static void openOtherUri(final String url, final Activity activity) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
    }

    /**
     * enable css framework from the css file setup
     *
     * @param ctx the context from the resources
     * @return the string
     */
    private static String cssframework(Context ctx, final @RawRes int resource_raw_file_name) {
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(ctx.getResources().openRawResource(resource_raw_file_name));
        sb.append("<style type=\"text/css\">");
        while (s.hasNextLine()) {
            sb.append(s.nextLine() + "\n");
        }
        sb.append("</style>");
        return sb.toString();
    }

    public static String sinaCommentbox(final String url_comment_box_id) {
        String template = "http://widget.weibo.com/distribution/comments.php?width=0&url=____COMMENTBOX___URL__ID____&appkey=3872527314&dpc=1";
        template = template.replace("____COMMENTBOX___URL__ID____", url_comment_box_id);
        //Log.d("webview", template);
        return template;
    }

    public static String fbCommentbox(final String url_comment_box_id) {
        String template = "https://www.facebook.com/plugins/comments.php?api_key=155803211143175&channel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter%2FX9pYjJn4xhW.js%3Fversion%3D41%23cb%3Df302928438%26domain%3Dpopbee.com%26origin%3Dhttp%253A%252F%252Fpopbee.com%252Ff3a9bd48c%26relation%3Dparent.parent&colorscheme=light&href=____COMMENTBOX___URL__ID____&locale=en_US&numposts=5&sdk=joey&skin=light&version=v2.3&width=100%25";
        try {
            template = template.replace("____COMMENTBOX___URL__ID____", URLEncoder.encode(url_comment_box_id, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //Log.d("webview", template);
        return template;
    }

    public static String cssByContentPost(Context context) {
        return cssframework(context, R.raw.main_css);
    }

    public static String cssByVideo(Context context) {
        return cssframework(context, R.raw.videoconfig);
    }

    public static void customToolBarForMainApp(Toolbar tb) {
    }

    public static void customToolBarForSingle(Toolbar tb, String cate) {
        /// tb.setNavigationIcon(R.mipmap.ic_action_arrow);
        tb.setTitle(cate);
    }

    public static String pbDate(Date mdat) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(mdat);
    }

    public static void routeUri(Uri in, Activity ctx) {
        if (in.getScheme().equalsIgnoreCase("http")) {
            if (in.getAuthority().endsWith("store.hypebeast.com")) {
                //assume we open the store app or open the play store to find the app
                startNewActivity("com.hypebeast.store", in.toString(), "shop in hypebeast", ctx);
            } else if (in.getAuthority().endsWith("hypebeast.com")) {
                if (in.getPathSegments().contains("tags")) {
                    //assume this is the tags
                    //  Util.startFeedList(in.toString(), getActivity());
                } else if (in.getPathSegments().contains("cate")) {
                    //assume this is the categories
                    //  Util.startFeedList(in.toString(), getActivity());
                } else {
                    //assume this is the article
                    //  Util.startNewArticle(in.toString(), getActivity());
                }
            } else if (in.getAuthority().endsWith("popbee.com")) {
                startNewActivity("com.popbee", in.toString(), "read Popbee", ctx);
            } else {
                openOtherUri(in.toString(), ctx);
            }
        } else if (in.getScheme().equalsIgnoreCase("app") && in.getAuthority().equalsIgnoreCase("popbee")) {
            String path = in.getLastPathSegment();
            long pid = Long.parseLong(path);
            routeSinglePage(pid, ctx);
        }
    }

    public static void stylePBCategories(Context c, final TextView text, final String cateText) {
        Resources res = c.getResources();
        if (cateText.equalsIgnoreCase("shoes")) {
            text.setTextColor(res.getColor(R.color.shoes));
        } else if (cateText.equalsIgnoreCase("fashion")) {
            text.setTextColor(res.getColor(R.color.fashion));
        } else if (cateText.equalsIgnoreCase("home and livinig")) {
            text.setTextColor(res.getColor(R.color.homeliving));
        } else if (cateText.equalsIgnoreCase("wedding")) {
            text.setTextColor(res.getColor(R.color.wedding));
        } else if (cateText.equalsIgnoreCase("lifestyle")) {
            text.setTextColor(res.getColor(R.color.lifestyle));
        } else if (cateText.equalsIgnoreCase("streetsnaps")) {
            text.setTextColor(res.getColor(R.color.streetsnaps));
        } else if (cateText.equalsIgnoreCase("celebrities")) {
            text.setTextColor(res.getColor(R.color.celebrities));
        } else if (cateText.equalsIgnoreCase("jewelry")) {
            text.setTextColor(res.getColor(R.color.jewelry));
        } else if (cateText.equalsIgnoreCase("handbags")) {
            text.setTextColor(res.getColor(R.color.handbags));
        } else if (cateText.equalsIgnoreCase("watches")) {
            text.setTextColor(res.getColor(R.color.watches));
        } else if (cateText.equalsIgnoreCase("travel")) {
            text.setTextColor(res.getColor(R.color.travel));
        } else if (cateText.equalsIgnoreCase("gadgets")) {
            text.setTextColor(res.getColor(R.color.gadgets));
        } else if (cateText.equalsIgnoreCase("health")) {
            text.setTextColor(res.getColor(R.color.health));
        } else if (cateText.equalsIgnoreCase("food")) {
            text.setTextColor(res.getColor(R.color.food));
        }
        text.setText(cateText);
    }
}
