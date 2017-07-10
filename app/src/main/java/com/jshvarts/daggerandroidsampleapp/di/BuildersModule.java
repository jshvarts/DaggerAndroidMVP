package com.jshvarts.daggerandroidsampleapp.di;

import com.jshvarts.daggerandroidsampleapp.lobby.LobbyActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract LobbyActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}
