package com.jshvarts.daggerandroidmvp.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.CallSuper;

import com.jakewharton.rxrelay2.BehaviorRelay;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public abstract class BasePresenter implements LifecycleObserver {

    public enum RequestState {
        IDLE,
        LOADING,
        COMPLETE,
        ERROR
    }

    protected BehaviorRelay<RequestState> requestStateObserver = BehaviorRelay.createDefault(RequestState.IDLE);

    private CompositeDisposable disposables = new CompositeDisposable();

    /**
     * Contains common setup actions needed for all presenters. Subclasses may override this.
     */
    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void setup() {
        Timber.d("lifecycle resume callback.");
    }

    /**
     * Contains common teardown/cleanup actions needed for all presenters. Subclasses may override this.
     */
    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void cleanup() {
        Timber.d("lifecycle destroy callback.");
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
