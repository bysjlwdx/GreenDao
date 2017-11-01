package com.bysjlwdx.greendao.Base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bysjlwdx.greendao.Dao.DaoMaster;
import com.bysjlwdx.greendao.Dao.DaoSession;

/**
 * =====作者=====
 * 智轩软件
 *www.bysjlwdx.com
 * =====时间=====
 * 2017/11/1.
 */
public class BaseApplication extends Application{

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
