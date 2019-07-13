package com.bawei.weekwoekdome2.net;

/**
 * Author:程金柱
 * Date:2019/7/13 10:44
 * Description：网络数据的回调接口
 */

public interface DataCallBack {
    void Success(Object data);

    void Error(String error);
}
