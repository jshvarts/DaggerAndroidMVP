package com.jshvarts.daggerandroidmvp.lobby;

import javax.inject.Inject;

import io.reactivex.Single;

class LobbyGreetingUseCase {
    private final LobbyGreetingRepository greetingRepository;

    @Inject
    LobbyGreetingUseCase(LobbyGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    Single<String> loadGreeting() {
        return greetingRepository.getGreeting();
    }
}
