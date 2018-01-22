package com.giphy.Controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.giphy.Database.GifsDB;
import com.giphy.Database.TblTrendingGifs;
import com.giphy.Database.TblTrendingMaster;
import com.giphy.MainActivity;
import com.giphy.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ND on 2018-01-19.
 */

public class InsertData extends AsyncTask<String, Integer, String> {
    TblTrendingMaster tblMaster;
    TblTrendingGifs tblTrendingGifs;
    private ArrayList<String> arrayTrendingUrl;
    private ArrayList<String> arrayTrendingCat;
    private ProgressDialog mProgressDialog1;
    private int mProgressStatus = 0;
    Context context;

    public InsertData(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        mProgressDialog1 = new ProgressDialog(context);
        mProgressDialog1.setMessage("Gathering Trending Gifs...");
        mProgressDialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog1.show();

    }

    @Override
    protected String doInBackground(String... params) {

        Log.i("insertdata","yes");
//        //create table
        tblMaster = new TblTrendingMaster(context,GifsDB.DBname,null,GifsDB.db_versionname);
        tblTrendingGifs = new TblTrendingGifs(context,GifsDB.DBname,null,GifsDB.db_versionname);

        //insert data into TblTrendingMaster
        arrayTrendingCat = new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.strTrendingCat)));
        tblMaster.insertTblTrendingMaster(arrayTrendingCat);

        //insert data into TblTrendingMaster
        int[] arrayMaster_id = context.getResources().getIntArray(R.array.intMaster_id);
        arrayTrendingUrl = new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.strTrendingUrl)));
        tblTrendingGifs.insertTblTrendingGifs(arrayMaster_id, arrayTrendingUrl);
        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        mProgressDialog1.dismiss();
        Intent mIntent = new Intent(context, MainActivity.class);
        context.startActivity(mIntent);

    }
}
