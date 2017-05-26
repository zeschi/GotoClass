package com.zes.bundle.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by zes on 16-1-15.
 */
public abstract class BaseFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    protected abstract int getContentViewId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    protected View getRootView() {
        return rootView;
    }

    protected void redirectActivity(Activity activity, Class c) {
        Intent intent = new Intent(activity, c);
        startActivity(intent);
    }
}
