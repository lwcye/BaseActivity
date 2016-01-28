package com.hbln.baseactivity.Custom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * 打开自动弹出的Dialog
 * Created by lwc on 2015/12/26.
 */
public class DialogSoftInput extends Dialog {
    public DialogSoftInput(Context context, int theme) {
        super(context, theme);
    }

    public DialogSoftInput(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                        | WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}
