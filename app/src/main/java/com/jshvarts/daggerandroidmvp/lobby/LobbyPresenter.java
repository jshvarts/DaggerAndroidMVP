package com.jshvarts.daggerandroidmvp.lobby;

import com.jshvarts.daggerandroidmvp.common.CommonGreetingUseCase;
import com.jshvarts.daggerandroidmvp.mvp.BasePresenter;
import com.jshvarts.daggerandroidmvp.rx.SchedulersFacade;

class LobbyPresenter extends BasePresenter
        implements LobbyGreetingContract.LobbyPresenter {

    private final LobbyGreetingContract.LobbyView view;

    private final CommonGreetingUseCase commonGreetingUseCase;

    private final LobbyGreetingUseCase lobbyGreetingUseCase;

    private final SchedulersFacade schedulersFacade;

    LobbyPresenter(LobbyGreetingContract.LobbyView view,
                   CommonGreetingUseCase commonGreetingUseCase,
                   LobbyGreetingUseCase lobbyGreetingUseCase,
                   SchedulersFacade schedulersFacade) {
        this.view = view;
        this.commonGreetingUseCase = commonGreetingUseCase;
        this.lobbyGreetingUseCase = lobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    public void loadCommonGreeting() {
        addDisposable(commonGreetingUseCase.loadGreeting()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .subscribe(view::displayCommonGreeting, view::displayCommonGreetingError)
        );
    }

    @Override
    public void loadLobbyGreeting() {
        addDisposable(lobbyGreetingUseCase.loadGreeting()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .subscribe(view::displayLobbyGreeting, view::displayLobbyGreetingError)
        );
    }
}
