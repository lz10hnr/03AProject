package com.jiyun.mvp_03a.model.biz;

import com.jiyun.mvp_03a.model.entity.ChinaLive;
import com.jiyun.mvp_03a.model.entity.UserInfo;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;

/**
 * Created by xingge on 2017/10/24.
 */

public interface IMineModel {

    void login(String username, String pwd, String keep_login, INetworkCallback<UserInfo> callback);



}
