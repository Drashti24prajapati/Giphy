package com.giphy.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * This class is used for storing and retrieving shared preference values.
 * * Created by drashti on 01/12/2015.
 */
public class SharedPrefrenceUtil {


    public static String sharedIsData="IsData";

    SharedPreferences prefs;

    public static String getPrefrence(Context context, String prefKey, String defValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(prefKey, defValue);
    }

    public static void setPrefrence(Context context, String prefKey, String value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(prefKey, value);
        editor.commit();
    }



    public static boolean getPrefrence(Context context, String prefKey, boolean defValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(prefKey, defValue);
    }


    public static void setPrefrence(Context context, String prefKey, boolean value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(prefKey, value);
        editor.commit();
    }


    public static int getPrefrence(Context context, String prefKey, int defValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(prefKey, defValue);
    }


    public static void setPrefrence(Context context, String prefKey, int value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(prefKey, value);
        editor.commit();

    }


    public static long getPrefrence(Context context, String prefKey, long defValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(prefKey, defValue);
    }


    public static void setPrefrence(Context context, String prefKey, long value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putLong(prefKey, value);
        editor.commit();
    }
}