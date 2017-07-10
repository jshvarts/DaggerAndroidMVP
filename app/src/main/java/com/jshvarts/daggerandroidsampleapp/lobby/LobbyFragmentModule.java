package com.jshvarts.daggerandroidsampleapp.lobby;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyFragment-specific dependencies here.
 *
 * Note: If you need access to dependencies injected by the parent activity, extend {@link LobbyActivityModule}.
 *
 */
@Module
public class LobbyFragmentModule {

    @Provides
    LobbyFragmentHelloService provideLobbyFragmentHelloService() {
        return new LobbyFragmentHelloService();
    }
}
