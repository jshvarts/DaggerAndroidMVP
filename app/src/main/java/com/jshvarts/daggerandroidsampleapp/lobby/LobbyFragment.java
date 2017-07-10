package com.jshvarts.daggerandroidsampleapp.lobby;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jshvarts.daggerandroidsampleapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class LobbyFragment extends Fragment {

    @Inject
    LobbyFragmentHelloService lobbyFragmentHelloService;

    @BindView(R.id.lobby_fragment_hello)
    TextView lobbyFragmentHelloTextView;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lobby_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sayFragmentHello();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void sayFragmentHello() {
        lobbyFragmentHelloTextView.setText(lobbyFragmentHelloService.sayHello());
    }
}
