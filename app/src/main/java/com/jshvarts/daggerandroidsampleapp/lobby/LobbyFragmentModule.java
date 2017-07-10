package com.jshvarts.daggerandroidsampleapp.lobby;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyFragment-specific dependencies here.
 */
@Module
public class LobbyFragmentModule {

    @Provides
    LobbyFragmentHelloService provideLobbyFragmentHelloService() {
        return new LobbyFragmentHelloService();
    }
}
