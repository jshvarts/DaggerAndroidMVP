package com.jshvarts.daggerandroidsampleapp.di;

import com.jshvarts.daggerandroidsampleapp.lobby.LobbyActivity;
import com.jshvarts.daggerandroidsampleapp.lobby.LobbyActivityModule;
import com.jshvarts.daggerandroidsampleapp.lobby.LobbyFragment;
import com.jshvarts.daggerandroidsampleapp.lobby.LobbyFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = LobbyActivityModule.class)
    abstract LobbyActivity bindLobbyActivity();

    @ContributesAndroidInjector(modules = LobbyFragmentModule.class)
    // or you can gain access to lobby dependencies from fragment via:
    // @ContributesAndroidInjector(modules = {LobbyFragmentModule.class, LobbyActivityModule.class})
    abstract LobbyFragment bindLobbyFragment();

    // Add bindings for other sub-components here
}
