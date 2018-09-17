package com.xitiz.airqualityindexnepal;

import android.app.Application;

public class AppDatabase extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

}


