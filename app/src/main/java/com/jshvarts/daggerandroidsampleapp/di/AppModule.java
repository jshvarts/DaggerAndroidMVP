package com.jshvarts.daggerandroidsampleapp.di;

import android.content.Context;

import com.jshvarts.daggerandroidsampleapp.App;
import com.jshvarts.daggerandroidsampleapp.common.CommonHelloService;
import com.jshvarts.daggerandroidsampleapp.common.CommonHelloServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    CommonHelloService provideCommonRepository() {
        return new CommonHelloServiceImpl();
    }
}
