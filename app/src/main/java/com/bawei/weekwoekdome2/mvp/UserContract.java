package com.bawei.weekwoekdome2.mvp;

import com.bawei.weekwoekdome2.base.mvp.BasePresenter;
import com.bawei.weekwoekdome2.base.mvp.IBaseModel;
import com.bawei.weekwoekdome2.base.mvp.IBaseView;
import com.bawei.weekwoekdome2.net.DataCallBack;

/**
 * Author:程金柱
 * Date:2019/7/13 10:29
 * Description：
 */

public interface UserContract {
    interface UserModel extends IBaseModel {
        void getLogin(String phone, String pwd, DataCallBack dataCallBack);

        void getRegister(String phone, String pwd, DataCallBack dataCallBack);
    }

    interface UserView extends IBaseView {
        void getLogin(Object data);

        void getRegister(Object data);
    }

    abstract class UserPresenter extends BasePresenter<UserModel, UserView> {
        public abstract void getLogin(String phone, String pwd);

        public abstract void getRegister(String phone, String pwd);
    }
}
