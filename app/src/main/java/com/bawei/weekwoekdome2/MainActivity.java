package com.bawei.weekwoekdome2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.weekwoekdome2.mvp.UserContract;
import com.bawei.weekwoekdome2.mvp.UserPresenter;

public class MainActivity extends AppCompatActivity implements UserContract.UserView {

    private static final String TAG = "";
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPresenter = new UserPresenter();
        userPresenter.getLogin("17900766822", "123");
    }

    @Override
    public void getLogin(Object data) {
        Log.i(TAG, "getLogin: "+data.toString());
    }

    @Override
    public void getRegister(Object data) {

    }
}
