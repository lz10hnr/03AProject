package com.jiyun.oschina.model.biz;

import com.jiyun.oschina.model.callback.INetworkcallback;

/**
 * Created by xingge on 2017/11/3.
 */

public interface IMineModel {

    void login(String username, String pwd, INetworkcallback networkcallback);
    void getUserInfo(String uid,INetworkcallback networkcallback);
}
