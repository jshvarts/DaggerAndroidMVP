package com.jshvarts.daggerandroidmvp.lobby;

interface LobbyGreetingContract {
    interface LobbyView {
        void onCommonGreetingButtonClicked();
        void onLobbyGreetingButtonClicked();

        void displayCommonGreeting(String greeting);
        void displayLobbyGreeting(String greeting);

        void displayCommonGreetingError(Throwable throwable);
        void displayLobbyGreetingError(Throwable throwable);
    }

    interface LobbyPresenter {
        void loadCommonGreeting();
        void loadLobbyGreeting();
    }
}
