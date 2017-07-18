package com.jshvarts.daggerandroidmvp.lobby;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jshvarts.daggerandroidmvp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import timber.log.Timber;

public class LobbyActivity extends LifecycleActivity implements LobbyGreetingContract.LobbyView {

    private static final String BUNDLE_DATA_KEY_GREETING = "greeting";

    @Inject
    LobbyPresenter presenter;

    @BindView(R.id.greeting_textview)
    TextView greetingTextView;

    @BindView(R.id.loading_indicator)
    ProgressBar loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activity);

        ButterKnife.bind(this);

        getLifecycle().addObserver(presenter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!TextUtils.isEmpty(greetingTextView.getText())) {
            outState.putCharSequence(BUNDLE_DATA_KEY_GREETING, greetingTextView.getText());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            greetingTextView.setText(savedInstanceState.getCharSequence(BUNDLE_DATA_KEY_GREETING));
        }
    }

    @Override
    @OnClick(R.id.common_greeting_button)
    public void onCommonGreetingButtonClicked() {
        presenter.loadCommonGreeting();
    }

    @Override
    @OnClick(R.id.lobby_greeting_button)
    public void onLobbyGreetingButtonClicked() {
        presenter.loadLobbyGreeting();
    }

    @Override
    public void displayGreeting(String greeting) {
        greetingTextView.setVisibility(View.VISIBLE);
        greetingTextView.setText(greeting);
    }

    @Override
    public void hideGreeting() {
        greetingTextView.setVisibility(View.GONE);
    }

    @Override
    public void displayGreetingError(Throwable throwable) {
        Timber.e(throwable.getMessage());
        Toast.makeText(this, R.string.greeting_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayLoadingIndicator() {
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        loadingIndicator.setVisibility(View.GONE);
    }
}
