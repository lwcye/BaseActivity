package com.hbln.baseactivity.Tool;

import android.content.Context;

import com.hbln.baseactivity.Application.BaseApplication;
import com.hbln.baseactivity.Config.ShareConstants;

/**
 * 储存xml简单数据
 * Created by lwc on 2015/12/11.
 */
public class SharedPreferencesUtil {
    private android.content.SharedPreferences share;
    private static SharedPreferencesUtil SharedPreferences;

    private SharedPreferencesUtil() {
        BaseApplication mApplication = BaseApplication.getInstance();
        share = mApplication.getSharedPreferences(ShareConstants.PREFERENTNAME, Context.MODE_PRIVATE);
    }

    public boolean contains(String paramString) {
        return share.contains(paramString);
    }

    public static SharedPreferencesUtil getInstance() {
        if (SharedPreferences == null) {
            SharedPreferences = new SharedPreferencesUtil();
        }
        return SharedPreferences;
    }

    public boolean getBoolean(String paramString) {
        return share.getBoolean(paramString, false);
    }

    public int getInt(String paramString) {
        return share.getInt(paramString, 0);
    }

    public String getString(String paramString) {
        return share.getString(paramString, null);
    }

    public void put(String Key, String value) {
        android.content.SharedPreferences.Editor localEditor = share.edit();
        localEditor.putString(Key, value);
        localEditor.apply();
    }


    public void putBoolean(String Key, Boolean value) {
        android.content.SharedPreferences.Editor localEditor = share.edit();
        localEditor.putBoolean(Key, value);
        localEditor.apply();
    }

    public void putInt(String Key, int value) {
        android.content.SharedPreferences.Editor localEditor = share.edit();
        localEditor.putInt(Key, value);
        localEditor.apply();
    }
}
