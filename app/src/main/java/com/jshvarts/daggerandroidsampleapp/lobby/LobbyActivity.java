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

    @BindView(R.id.hello_from_common)
    protected TextView helloFromCommonTextView;

    @Inject
    protected CommonHelloService commonRepository;

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
    }

    private void sayCommonHello() {
        String helloText = commonRepository.sayHello();
        helloFromCommonTextView.setText(helloText);
    }
}
