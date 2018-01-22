package com.giphy.Controller;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownloadGif extends AsyncTask<String, Void, Void> {
    Context context;
    private static final int PERMISSION_REQUEST_CODE = 1;
    public DownloadGif(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... voids) {
        saveGIF(voids[0]);
        return null;
    }

    private void saveGIF(String url) {
        if (checkPermission() == true) {
            try {
                String TAG = "Download";
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "gif" + System.currentTimeMillis() + ".gif");

                long startTime = System.currentTimeMillis();
                InputStream is = new URL(url).openStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] img = new byte[1024];
                int current = 0;
                while ((current = bis.read()) != -1) {
                    baos.write(current);
                }
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


}