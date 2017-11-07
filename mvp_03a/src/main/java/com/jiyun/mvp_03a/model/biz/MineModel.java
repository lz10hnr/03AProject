package com.jiyun.mvp_03a.model.biz;

import com.jiyun.mvp_03a.config.Uris;
import com.jiyun.mvp_03a.model.entity.ChinaLive;
import com.jiyun.mvp_03a.model.entity.UserInfo;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;
import com.jiyun.mvp_03a.model.net.http.HttpFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingge on 2017/10/24.
 */

public class MineModel implements IMineModel {
    @Override
    public void login(String username, String pwd, String keep_login, INetworkCallback<UserInfo> callback) {
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        params.put("pwd",pwd);
        params.put("keep_login",keep_login);
        HttpFactory.create().get(Uris.LOGIN,params,callback);
    }


}
