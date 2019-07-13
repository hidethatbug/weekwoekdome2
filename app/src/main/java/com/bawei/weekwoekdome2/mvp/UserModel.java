package com.bawei.weekwoekdome2.mvp;

import com.bawei.weekwoekdome2.Api;
import com.bawei.weekwoekdome2.base.mvp.IBaseModel;
import com.bawei.weekwoekdome2.entry.LoginEntry;
import com.bawei.weekwoekdome2.entry.RegisterEntry;
import com.bawei.weekwoekdome2.net.DataCallBack;
import com.bawei.weekwoekdome2.net.HttpUtile;
import com.bawei.weekwoekdome2.net.UserApiService;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:程金柱
 * Date:2019/7/13 10:46
 * Description：
 */

public class UserModel implements UserContract.UserModel {
    /**
     * 登录
     *
     * @param phone
     * @param pwd
     * @param dataCallBack
     */
    @Override
    public void getLogin(String phone, String pwd, final DataCallBack dataCallBack) {
        UserApiService retifit = HttpUtile.getHttpUtile().getRetifit(UserApiService.class);
        retifit.getLoginData(Api.LOGIN_URL, phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntry>() {
                    @Override
                    public void accept(LoginEntry loginEntry) throws Exception {
                        dataCallBack.Success(loginEntry);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        dataCallBack.Error(throwable.toString());
                    }
                });
    }

    /**
     * 注册
     *
     * @param phone
     * @param pwd
     * @param dataCallBack
     */
    @Override
    public void getRegister(String phone, String pwd, final DataCallBack dataCallBack) {
        UserApiService retifit = HttpUtile.getHttpUtile().getRetifit(UserApiService.class);
        retifit.getRegisterData(Api.REGISTER_URL, phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterEntry>() {
                    @Override
                    public void accept(RegisterEntry registerEntry) throws Exception {
                        dataCallBack.Success(registerEntry);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        dataCallBack.Error(throwable.toString());
                    }
                });
    }
}
