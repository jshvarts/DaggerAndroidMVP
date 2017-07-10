package com.jshvarts.daggerandroidsampleapp.lobby;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
public class LobbyActivityModule {

    @Provides
    LobbyHelloService provideLobbyHelloService() {
        return new LobbyHelloService();
    }
}
