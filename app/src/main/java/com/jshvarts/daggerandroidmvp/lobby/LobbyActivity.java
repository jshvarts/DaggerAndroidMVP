package com.jshvarts.daggerandroidmvp.lobby;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.jshvarts.daggerandroidmvp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LobbyActivity extends LifecycleActivity implements LobbyGreetingContract.LobbyView {

    private static final String BUNDLE_DATA_KEY_COMMON_GREETING = "commonGreeting";
    private static final String BUNDLE_DATA_KEY_LOBBY_GREETING = "lobbyGreeting";

    @Inject
    LobbyPresenter presenter;

    @BindView(R.id.common_greeting_textview)
    TextView commonGreetingTextView;

    @BindView(R.id.lobby_greeting_textview)
    TextView lobbyGreetingTextView;

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
        if (!TextUtils.isEmpty(commonGreetingTextView.getText())) {
            outState.putCharSequence(BUNDLE_DATA_KEY_COMMON_GREETING, commonGreetingTextView.getText());
        }
        if (!TextUtils.isEmpty(lobbyGreetingTextView.getText())) {
            outState.putCharSequence(BUNDLE_DATA_KEY_LOBBY_GREETING, lobbyGreetingTextView.getText());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            commonGreetingTextView.setText(savedInstanceState.getCharSequence(BUNDLE_DATA_KEY_COMMON_GREETING));
            lobbyGreetingTextView.setText(savedInstanceState.getCharSequence(BUNDLE_DATA_KEY_LOBBY_GREETING));
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
    public void displayCommonGreeting(String greeting) {
        commonGreetingTextView.setText(greeting);
    }

    @Override
    public void displayLobbyGreeting(String greeting) {
        lobbyGreetingTextView.setText(greeting);
    }

    @Override
    public void displayCommonGreetingError(Throwable throwable) {
        Toast.makeText(this, R.string.common_greeting_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayLobbyGreetingError(Throwable throwable) {
        Toast.makeText(this, R.string.lobby_greeting_error, Toast.LENGTH_SHORT).show();
    }
}
