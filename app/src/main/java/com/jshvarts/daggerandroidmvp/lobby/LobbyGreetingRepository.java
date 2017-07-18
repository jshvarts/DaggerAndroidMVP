package com.jshvarts.daggerandroidmvp.lobby;

import io.reactivex.Single;

class LobbyGreetingRepository {
    Single<String> getGreeting() {
        return Single.just("Hello from LobbyGreetingRepository");
    }
}
