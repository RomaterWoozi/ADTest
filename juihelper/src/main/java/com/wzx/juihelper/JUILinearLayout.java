package com.wzx.juihelper;

import android.app.NativeActivity;

import android.widget.LinearLayout;

/**
 * Created By WuZhouXing TestApplication
 * 2019/4/16 17:55
 */
public class JUILinearLayout extends LinearLayout {
    public JUILinearLayout(NativeActivity context) {
        super(context);
    }

    public JUIForwardingPopupWindow getDummyWindow() {
        return null;
    }
}
