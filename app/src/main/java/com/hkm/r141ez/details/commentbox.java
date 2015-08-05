package com.hkm.r141ez.details;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;

import com.hkm.r141ez.R;

/**
 * Created by hesk on 23/7/15.
 */
public class commentbox extends WebviewCommentBox {
    //private String url_id;
    private int fragment_comment_box_type;

    public static commentbox B(final Bundle b) {
        final commentbox t = new commentbox();
        t.setArguments(b);
        return t;
    }

    public static Bundle fbIntent(final @StringRes int title, final String id_comment) {
        final Bundle n = new Bundle();
        n.putInt(FRAGMENTTITLE_RESID, title);
        n.putString(COMMENT_BOX_ID, id_comment);
        n.putInt(REQUEST_TYPE, FB_COMMENT);
        return n;
    }

    @Override
    protected int commentbox_layout_id() {
        return R.layout.webviewsimple;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        fragment_comment_box_type = getArguments().getInt(WebviewCommentBox.REQUEST_TYPE);
        //  url_id = getArguments().getString(COMMENT_BOX_ID);
        initBinding(view);

        setup_commentbox(getArguments().getString(COMMENT_BOX_ID));
    }

    public void complete() {
        completeloading();
    }

}
