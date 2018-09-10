package com.xitiz.airqualityindexnepal;

import android.app.Application;

import com.xitiz.airqualityindexnepal.di.AppModule;
import com.xitiz.airqualityindexnepal.di.DaggerNetComponent;
import com.xitiz.airqualityindexnepal.di.NetComponent;
import com.xitiz.airqualityindexnepal.di.NetModule;

import io.paperdb.Paper;

public class MyApp extends Application {
    NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        /*Dagger2 component*/
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://api.waqi.info"))
                .build();

        /*Initialize the Paper DB*/
        Paper.init(getBaseContext());
    }

    NetComponent getNetComponent() {
        return netComponent;
    }
}
