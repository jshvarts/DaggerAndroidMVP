package com.jshvarts.daggerandroidmvp.common;

import javax.inject.Inject;

import io.reactivex.Single;

public class CommonGreetingUseCase {
    private final CommonGreetingRepository greetingRepository;

    @Inject
    public CommonGreetingUseCase(CommonGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Single<String> loadGreeting() {
        return greetingRepository.getGreeting();
    }
}
