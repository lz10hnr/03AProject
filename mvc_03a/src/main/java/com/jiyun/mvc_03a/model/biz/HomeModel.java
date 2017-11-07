package com.jiyun.mvc_03a.model.biz;

import com.jiyun.mvc_03a.config.Urls;
import com.jiyun.mvc_03a.model.HttpFactory;
import com.jiyun.mvc_03a.model.net.IHttp;
import com.jiyun.mvc_03a.model.net.OKhttpUtils;
import com.jiyun.mvc_03a.model.net.callback.INetworkCallback;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by xingge on 2017/10/20.
 */

public class HomeModel implements IHomeModel {

    /**
     * 获取首页数据
     * @param key
     * @param pno
     * @param callback
     */
    @Override
    public <T> void loadHomeList(String key, int pno, INetworkCallback<T> callback) {
        Map<String,String> params = new HashMap<>();
        params.put("key",key);
        params.put("pno",pno+"");
        HttpFactory.create().get(Urls.HOMELIST,params,callback);
    }

    @Override
    public <T> void loadHomeBanner(INetworkCallback<T> callback) {
        HttpFactory.create().get(Urls.HOMEBANNER,callback);
    }
}
