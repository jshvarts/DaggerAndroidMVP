package com.jshvarts.daggerandroidmvp.di;

import com.jshvarts.daggerandroidmvp.lobby.LobbyActivity;
import com.jshvarts.daggerandroidmvp.lobby.LobbyModule;
import com.jshvarts.daggerandroidmvp.lobby.LobbyViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {LobbyViewModule.class, LobbyModule.class})
    abstract LobbyActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}
