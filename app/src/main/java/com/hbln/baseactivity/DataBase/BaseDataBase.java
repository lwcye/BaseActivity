package com.hbln.baseactivity.DataBase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 这个类的作用
 * Created by lwc on 2015/12/26.
 */
public class BaseDataBase extends SQLiteOpenHelper {
    static String DBName = "dbname.db";
    static int version = 1;
    private static BaseDataBase database;


    public BaseDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 数据库实现类
     * @param context 上下文
     * @return 数据库
     */
    public static BaseDataBase getSqlHelper(Context context) {
        if (database == null) {
            PackageInfo p = null;
            try {
                p = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (p!=null){
                version = p.versionCode;
            }
            database = new BaseDataBase(context, DBName, null, version);
        }
        return database;
    }

    /**
     * 数据库建立过程，APP安装时只执行一次
     *可以在这里进行建表操作
     * @param db 数据库
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String creat_table = "";
        db.execSQL(creat_table);
    }

    /**
     * 版本升级，数据库操作
     * 版本号不同时调用此方法
     * @param db 数据库
     * @param oldVersion 旧版本号
     * @param newVersion 新版本号
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //可以在这里保存数据

        // 执行OnCreate方法，这个方法中放的是表的初始化操作工作，比如创建新表之类的
        onCreate(db);

        //把保存的数据导入表中
    }
}
