package com.jshvarts.daggerandroidsampleapp.lobby;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jshvarts.daggerandroidsampleapp.R;
import com.jshvarts.daggerandroidsampleapp.common.CommonHelloService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LobbyActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    CommonHelloService commonHelloService;

    @Inject
    LobbyHelloService lobbyHelloService;

    @BindView(R.id.common_hello)
    TextView commonHelloTextView;

    @BindView(R.id.lobby_hello)
    TextView lobbyHelloTextView;

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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
