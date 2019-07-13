package com.bawei.weekwoekdome2.base.mvp;

/**
 * Author:程金柱
 * Date:2019/7/13 10:12
 * Description：
 */

public abstract class BasePresenter<M, V> {
    public M model;
    public V view;

    /**
     * 绑定model和view
     *
     * @param model
     * @param view
     */
    public void bind(M model, V view) {
        this.model = model;
        this.view = view;
    }

    /**
     * 解绑
     *
     *
     */
    public void unBind() {
        if (model != null) {
            model = null;
        }
        if (view != null) {
            view = null;
        }
        System.gc();
    }

}
