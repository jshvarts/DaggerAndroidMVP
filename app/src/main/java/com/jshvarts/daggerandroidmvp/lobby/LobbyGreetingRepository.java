package com.jshvarts.daggerandroidmvp.lobby;

import io.reactivex.Single;

public class LobbyGreetingRepository {
    Single<String> getGreeting() {
        return Single.just("Hello from LobbyGreetingRepository");
    }
}
