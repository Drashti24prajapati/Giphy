package com.giphy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.giphy.Controller.InsertData;
import com.giphy.Controller.SharedPrefrenceUtil;

public class SplashScreen extends Activity {
    private Boolean Isdata;
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);


        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                {
                    Isdata = SharedPrefrenceUtil.getPrefrence(getApplicationContext(), SharedPrefrenceUtil.sharedIsData, true);
                    if (Isdata == true) {
                        new InsertData(SplashScreen.this).execute();
                        SharedPrefrenceUtil.setPrefrence(getApplicationContext(), SharedPrefrenceUtil.sharedIsData, false);
                    }
                    else
                    {
                        Intent mIntent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(mIntent);
                    }
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

       mHandler.postDelayed(mRunnable, 1000);

    }

}
