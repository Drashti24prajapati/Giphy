package com.giphy.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ND on 2018-01-19.
 */

public class GifsDB extends SQLiteOpenHelper {

    public static final String DBname = "GifsDB.db";
    public static final int db_versionname = 5;
    private static Context context;

    public GifsDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBname, null, db_versionname);
        context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
