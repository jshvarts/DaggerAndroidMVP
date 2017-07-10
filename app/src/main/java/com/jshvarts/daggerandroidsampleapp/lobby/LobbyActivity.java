package com.jshvarts.daggerandroidsampleapp.lobby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jshvarts.daggerandroidsampleapp.R;
import com.jshvarts.daggerandroidsampleapp.common.CommonHelloService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class LobbyActivity extends AppCompatActivity {

    @BindView(R.id.common_hello)
    protected TextView commonHelloTextView;

    @BindView(R.id.lobby_hello)
    protected TextView lobbyHelloTextView;

    @Inject
    protected CommonHelloService commonHelloService;

    @Inject
    protected LobbyHelloService lobbyHelloService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activity);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sayCommonHello();

        sayLobbyHello();
    }

    private void sayCommonHello() {
        commonHelloTextView.setText(commonHelloService.sayHello());
    }

    private void sayLobbyHello() {
        lobbyHelloTextView.setText(lobbyHelloService.sayHello());
    }
}
