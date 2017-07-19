package com.jshvarts.daggerandroidmvp.lobby;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jshvarts.daggerandroidmvp.common.CommonGreetingUseCase;
import com.jshvarts.daggerandroidmvp.mvp.BasePresenter;
import com.jshvarts.daggerandroidmvp.rx.SchedulersFacade;

import io.reactivex.Observable;
import io.reactivex.Single;
import timber.log.Timber;

class LobbyPresenter extends BasePresenter<LobbyGreetingContract.LobbyView>
        implements LobbyGreetingContract.LobbyPresenter {

    private final CommonGreetingUseCase commonGreetingUseCase;

    private final LobbyGreetingUseCase lobbyGreetingUseCase;

    private final SchedulersFacade schedulersFacade;

    private final BehaviorRelay<RequestState> requestStateObserver
            = BehaviorRelay.createDefault(RequestState.IDLE);

    LobbyPresenter(LobbyGreetingContract.LobbyView view,
                   CommonGreetingUseCase commonGreetingUseCase,
                   LobbyGreetingUseCase lobbyGreetingUseCase,
                   SchedulersFacade schedulersFacade) {
        super(view);
        this.commonGreetingUseCase = commonGreetingUseCase;
        this.lobbyGreetingUseCase = lobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;

        observeRequestState();
    }

    @Override
    public void loadCommonGreeting() {
        loadGreeting(commonGreetingUseCase.loadGreeting());
    }

    @Override
    public void loadLobbyGreeting() {
        loadGreeting(lobbyGreetingUseCase.loadGreeting());
    }

    private void loadGreeting(Single<String> greetingSingle) {
        addDisposable(greetingSingle
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(s -> publishRequestState(RequestState.LOADING))
                .doOnSuccess(s -> publishRequestState(RequestState.COMPLETE))
                .doOnError(t -> publishRequestState(RequestState.ERROR))
                .subscribe(view::displayGreeting, view::displayGreetingError)
        );
    }

    private void publishRequestState(RequestState requestState) {
        addDisposable(Observable.just(requestState)
                .observeOn(schedulersFacade.ui())
                .subscribe(requestStateObserver));
    }

    private void observeRequestState() {
        requestStateObserver.subscribe(requestState -> {
            switch (requestState) {
                case IDLE:
                    break;
                case LOADING:
                    view.hideGreeting();
                    view.setLoadingIndicator(true);
                    break;
                case COMPLETE:
                    view.setLoadingIndicator(false);
                    break;
                case ERROR:
                    view.setLoadingIndicator(false);
                    break;
            }
        }, Timber::e);
    }
}
