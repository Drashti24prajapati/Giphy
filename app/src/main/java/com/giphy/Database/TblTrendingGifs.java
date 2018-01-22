package com.giphy.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.giphy.Model.ModelTrending;

import java.util.ArrayList;

/**
 * Created by ND on 2018-01-19.
 */

public class TblTrendingGifs extends GifsDB {

    private static SQLiteDatabase databaseHelper;
    public static final String TBL_TRENDINGGIFS = "TblTrendingGifs";
    public static final String TredningGifID = "TredningGifID";
    public static final String Master_ID = "masterId";
    public static final String TRENDIGIF_URL = "trendingUrl";
    public static final String TRENDIGIf_FAV_STATUS = "trendingGifFavStatus";


    public TblTrendingGifs(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        databaseHelper = this.getWritableDatabase();
        databaseHelper.execSQL(TblTrendingGifs.queryCrateTrendingGifs);
    }

    //create table for trending gifs
    public static final String queryCrateTrendingGifs = "CREATE TABLE IF NOT EXISTS "
            + TblTrendingGifs.TBL_TRENDINGGIFS
            + "("
            + TblTrendingGifs.TredningGifID
            + " integer primary key autoincrement ,"
            + TblTrendingGifs.Master_ID
            + " integer ,"
            + TblTrendingGifs.TRENDIGIF_URL
            + " text ,"
            + TblTrendingGifs.TRENDIGIf_FAV_STATUS
            + " integer "
            + ");";

    //insert data in trending gifs table //0=unfav and 1 = fav
    public void insertTblTrendingGifs(int[] arrayMasterID, ArrayList<String> arrayTrendingUrl) {
        for (int i = 0; i < arrayTrendingUrl.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(TblTrendingGifs.Master_ID, arrayMasterID[i]);
            values.put(TblTrendingGifs.TRENDIGIF_URL, arrayTrendingUrl.get(i));
            values.put(TblTrendingGifs.TRENDIGIf_FAV_STATUS, 0);
            databaseHelper.insert(TblTrendingGifs.TBL_TRENDINGGIFS, null, values);

        }
    }
    public int Isstatus(int trendingGifId) {
        int status = 0;
        String StatusFavUnfav = "select trendingGifFavStatus as status from TblTrendingGifs where TredningGifID=" + trendingGifId + ";";
        Cursor cursor = databaseHelper.rawQuery(StatusFavUnfav, null);
        if (cursor.moveToFirst()) {
            do {
                status = cursor.getInt(cursor.getColumnIndex("status"));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return status;
    }
    public int IsFav(int trendingGifId) {
        int status = 0;
        int favstatus=0;
        String StatusFavUnfav = "select trendingGifFavStatus as status from TblTrendingGifs where TredningGifID=" + trendingGifId + ";";
        Cursor cursor = databaseHelper.rawQuery(StatusFavUnfav, null);
        if (cursor.moveToFirst()) {
            do {
                status = cursor.getInt(cursor.getColumnIndex("status"));
            } while (cursor.moveToNext());
        }

        ContentValues values = new ContentValues();
        String where_clause = TblTrendingGifs.TredningGifID + "=" + trendingGifId;
        if (status == 0) {
            values.put(TblTrendingGifs.TRENDIGIf_FAV_STATUS, 1);

            favstatus=1;
        } else {
            values.put(TblTrendingGifs.TRENDIGIf_FAV_STATUS, 0);
            favstatus=0;
        }
        databaseHelper.update(TblTrendingGifs.TBL_TRENDINGGIFS, values, where_clause, null);
        cursor.close();
        return favstatus;
    }

    public ArrayList<ModelTrending> getTrendingGifs() {
        String getTrendingGifs = "SELECT * FROM TblTrendingGifs";

        ArrayList<ModelTrending> arrayGetTrendingGifs = new ArrayList<ModelTrending>();
        Cursor cursor = databaseHelper.rawQuery(getTrendingGifs, null);
        if (cursor.moveToFirst()) {
            do {
                ModelTrending modelTrndingGifs = new ModelTrending();
                modelTrndingGifs.setTrendingId(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.TredningGifID)));
                modelTrndingGifs.setTrendingMasterID(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.Master_ID)));
                modelTrndingGifs.setTrendingGifUrl(cursor.getString(cursor
                        .getColumnIndex(TblTrendingGifs.TRENDIGIF_URL)));
                modelTrndingGifs.setTrendingFavStatus(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.TRENDIGIf_FAV_STATUS)));

                arrayGetTrendingGifs.add(modelTrndingGifs);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return arrayGetTrendingGifs;
    }

    public ArrayList<ModelTrending> getFilterGIF(String strSearchitem) {
        String getTrendingGifs = "SELECT * FROM TblTrendingGifs tg,TblTrendingMaster tm  where tg.masterId=tm.masterId and trendingCat like '" +strSearchitem+"%'";

        ArrayList<ModelTrending> arrayGetTrendingGifs = new ArrayList<ModelTrending>();
        Cursor cursor = databaseHelper.rawQuery(getTrendingGifs, null);
        if (cursor.moveToFirst()) {
            do {
                ModelTrending modelTrndingGifs = new ModelTrending();
                modelTrndingGifs.setTrendingId(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.TredningGifID)));
                modelTrndingGifs.setTrendingMasterID(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.Master_ID)));
                modelTrndingGifs.setTrendingGifUrl(cursor.getString(cursor
                        .getColumnIndex(TblTrendingGifs.TRENDIGIF_URL)));
                modelTrndingGifs.setTrendingFavStatus(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.TRENDIGIf_FAV_STATUS)));

                arrayGetTrendingGifs.add(modelTrndingGifs);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return arrayGetTrendingGifs;
    }
    public ArrayList<ModelTrending> getFavTrendingGifs() {
        String getTrendingGifs = "SELECT * FROM " + TblTrendingGifs.TBL_TRENDINGGIFS + " where " + TblTrendingGifs.TRENDIGIf_FAV_STATUS + " = 1";
        ArrayList<ModelTrending> arrayGetFavTrendingGifs = new ArrayList<ModelTrending>();
        Cursor cursor = databaseHelper.rawQuery(getTrendingGifs, null);
        if (cursor.moveToFirst()) {
            do {
                ModelTrending modelTrndingGifs = new ModelTrending();
                modelTrndingGifs.setTrendingId(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.TredningGifID)));
                modelTrndingGifs.setTrendingMasterID(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.Master_ID)));
                modelTrndingGifs.setTrendingGifUrl(cursor.getString(cursor
                        .getColumnIndex(TblTrendingGifs.TRENDIGIF_URL)));
                modelTrndingGifs.setTrendingFavStatus(cursor.getInt(cursor
                        .getColumnIndex(TblTrendingGifs.TRENDIGIf_FAV_STATUS)));

                arrayGetFavTrendingGifs.add(modelTrndingGifs);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return arrayGetFavTrendingGifs;
    }

}