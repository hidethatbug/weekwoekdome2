package com.bawei.weekwoekdome2.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:程金柱
 * Date:2019/7/13 10:04
 * Description：fragment 的基类
 *
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(bindLayout(), container, false);
        bind = ButterKnife.bind(this, view);
        bindView();
        bindData();
        return view;
    }

    protected abstract void bindData();

    protected abstract void bindView();

    protected abstract int bindLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
