package com.github.nukc.sample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.nukc.stateview.StateView;


/**
 * A inject fragment sample
 */
public class InjectFragment extends Fragment {

    private StateView mStateView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inject, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("inject fragment");
        toolbar.inflateMenu(R.menu.menu_inject);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.show_empty:
                        mStateView.showEmpty();
                        break;
                    case R.id.show_retry:
                        mStateView.showRetry();
                        break;
                    case R.id.show_loading:
                        mStateView.showLoading();
                        break;
                    case R.id.show_content:
                        mStateView.showContent();
                        break;
                }
                return false;
            }
        });

        mStateView = StateView.inject(view, true);

        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                //do something
            }
        });

        return view;
    }

}
