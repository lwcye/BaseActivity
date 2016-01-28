package com.hbln.baseactivity.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 这个类的作用
 * Created by lwc on 2015/12/26.
 */
public class DataBaseUtilDAO implements DataBaseUtil{
    private static DataBaseUtilDAO myHelper;
    private BaseDataBase helper;
    SQLiteDatabase db;

    /**
     * 构造类方法
     * @param context 上下文
     */
    private DataBaseUtilDAO(Context context) {
        helper = BaseDataBase.getSqlHelper(context);
    }


}
