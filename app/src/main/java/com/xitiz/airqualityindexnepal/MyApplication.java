package com.xitiz.airqualityindexnepal;

import android.app.Application;

import io.paperdb.Paper;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        /*Initialize the Paper DB*/
        Paper.init(getBaseContext());
    }
}
