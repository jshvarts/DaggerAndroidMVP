package com.jshvarts.daggerandroidmvp.lobby;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LobbyViewModule {

    @Binds
    abstract LobbyGreetingContract.LobbyView provideLobbyView(LobbyActivity lobbyActivity);
}
