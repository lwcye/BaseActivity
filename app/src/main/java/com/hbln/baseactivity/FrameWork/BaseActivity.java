package com.hbln.baseactivity.FrameWork;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.xutils.x;

/**
 * 基本Activity类
 * Created by lwc on 2015/12/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        x.view().inject(this);
        initView();
        initEvent();
        initData();
    }

    /**
     * 返回
     *
     * @param view
     */
    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        UtilFactory.getUiUtil().nofinish(this);
    }

    protected Context getContext() {
        return this;
    }

    protected BaseActivity getActivity() {
        return this;
    }
}
