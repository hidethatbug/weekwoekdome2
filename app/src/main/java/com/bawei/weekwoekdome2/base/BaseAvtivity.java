package com.bawei.weekwoekdome2.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:程金柱
 * Date:2019/7/13 9:56
 * Description：activity的基类
 */

public abstract class BaseAvtivity extends AppCompatActivity {

    private Unbinder bind;
    private boolean choose = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);
        setContentView(bindLayout());
        bindView();
        bindData();
    }

    protected abstract void bindData();

    protected abstract void bindView();

    protected abstract int bindLayout();

    /**
     * 有参跳转
     *
     * @param context
     * @param aClass
     * @param bundle
     */
    public void startNextPage(Context context, Class<?> aClass, Bundle bundle) {
        Intent intent = new Intent(context, aClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 无参跳转
     *
     * @param context
     * @param aClass
     */
    public void startNextPage(Context context, Class<?> aClass) {
        startActivity(new Intent(context, aClass));
    }

    /**
     * 吐司的方法
     *
     * @param msg
     */
    public void showToast(String msg) {
        if (msg != null && !msg.equals("")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * 沉浸式状态栏是否开启
     *
     * @param choose
     */
    public void staticsBar(boolean choose) {
        if (choose) {
            ImmersionBar.with(this)
                    .transparentStatusBar();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
