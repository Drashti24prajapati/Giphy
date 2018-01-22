package com.giphy.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ND on 2018-01-19.
 */

public class TblTrendingMaster extends GifsDB{

    private static SQLiteDatabase databaseHelper;
    private static TblTrendingMaster instance;
    public static final String TBL_TRENDING_MASTER = "TblTrendingMaster";
    public static final String MASTER_ID = "masterId";
    public static final String TRENDING_CATEGORY = "trendingCat";


    public TblTrendingMaster(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        databaseHelper = this.getWritableDatabase();
        databaseHelper.execSQL(TblTrendingMaster.queryCreateTrendingTabMaster);
        Log.i("create_master:", "" + queryCreateTrendingTabMaster);
    }

   // create table
    public static final String queryCreateTrendingTabMaster = "CREATE TABLE IF NOT EXISTS "
            + TblTrendingMaster.TBL_TRENDING_MASTER
            + "("
            + TblTrendingMaster.MASTER_ID
            + " integer primary key autoincrement ,"
            + TblTrendingMaster.TRENDING_CATEGORY
            +" text "
            + ");";

    //insert data into table master
    public void insertTblTrendingMaster(ArrayList<String> arrayTrendingCat) {
        for (int i = 0; i < arrayTrendingCat.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(TblTrendingMaster.TRENDING_CATEGORY, arrayTrendingCat.get(i));
            Log.i("levelgroupname", arrayTrendingCat.get(i));
            databaseHelper.insert(TblTrendingMaster.TBL_TRENDING_MASTER, null, values);
        }
    }
}
