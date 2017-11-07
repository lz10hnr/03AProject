package com.jiyun.oschina.model.biz;

import com.jiyun.oschina.config.Urls;
import com.jiyun.oschina.model.callback.INetworkcallback;
import com.jiyun.oschina.model.http.HttpFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingge on 2017/11/3.
 */

public class MineModel implements IMineModel{

    @Override
    public void login(String username, String pwd, INetworkcallback networkcallback) {
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        params.put("pwd",pwd);
        params.put("keep_login","1");
        HttpFactory.getIntance().get(Urls.LOGIN,params,networkcallback);
    }

    @Override
    public void getUserInfo(String uid, INetworkcallback networkcallback) {
        Map<String,String> params = new HashMap<>();
        params.put("uid",uid);
        HttpFactory.getIntance().get(Urls.USERINFO,params,networkcallback);
    }
}
