package com.bawei.weekwoekdome2.net;

import com.bawei.weekwoekdome2.Api;
import com.bawei.weekwoekdome2.entry.LoginEntry;
import com.bawei.weekwoekdome2.entry.RegisterEntry;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Author:程金柱
 * Date:2019/7/13 10:56
 * Description：
 */

public interface UserApiService {

    @POST
    @FormUrlEncoded
    Observable<LoginEntry> getLoginData(
            @Url String url,
            @Field("phone") String phone,
            @Field("pwd") String pwd
    );

    @POST
    @FormUrlEncoded
    Observable<RegisterEntry> getRegisterData(
            @Url String url,
            @Field("phone") String phone,
            @Field("pwd") String pwd
    );
}
