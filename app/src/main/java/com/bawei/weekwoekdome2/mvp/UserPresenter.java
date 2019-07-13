package com.bawei.weekwoekdome2.mvp;

import com.bawei.weekwoekdome2.MainActivity;
import com.bawei.weekwoekdome2.net.DataCallBack;

/**
 * Author:程金柱
 * Date:2019/7/13 10:55
 * Description：
 */

public class UserPresenter extends UserContract.UserPresenter {



    @Override
    public void getLogin(String phone, String pwd) {
        model = new UserModel();
        view=new MainActivity();
//        view = new MainActivity();
        model.getLogin(phone, pwd, new DataCallBack() {
            @Override
            public void Success(Object data) {
              view.getLogin(data);
            }

            @Override
            public void Error(String error) {

            }
        });
    }

    @Override
    public void getRegister(String phone, String pwd) {

    }
}
