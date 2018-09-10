package com.xitiz.airqualityindexnepal.di;


import com.xitiz.airqualityindexnepal.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity);
}
