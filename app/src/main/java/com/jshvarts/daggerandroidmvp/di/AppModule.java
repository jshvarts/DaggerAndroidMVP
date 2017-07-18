package com.jshvarts.daggerandroidmvp.di;

import android.content.Context;

import com.jshvarts.daggerandroidmvp.App;
import com.jshvarts.daggerandroidmvp.common.CommonGreetingRepository;

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
    CommonGreetingRepository provideCommonHelloService() {
        return new CommonGreetingRepository();
    }
}
