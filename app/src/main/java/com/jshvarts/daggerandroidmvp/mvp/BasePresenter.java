package com.jshvarts.daggerandroidmvp.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.CallSuper;
import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter implements LifecycleObserver {
    private static final String LOG_TAG = BasePresenter.class.getSimpleName();

    private CompositeDisposable disposables = new CompositeDisposable();

    /**
     * Contains common setup actions needed for all presenters. Subclasses may override this.
     */
    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void setup() {
        Log.d(LOG_TAG, "lifecycle resume callback.");
    }

    /**
     * Contains common teardown/cleanup actions needed for all presenters. Subclasses may override this.
     */
    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void cleanup() {
        Log.d(LOG_TAG, "lifecycle destroy callback.");
        disposables.dispose();
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
