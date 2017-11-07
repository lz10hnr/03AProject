package com.jiyun.mvp_03a.model.net.http;

import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;

import java.util.Map;

/**
 * Created by xingge on 2017/10/24.
 */

public interface IHttp {

    <T> void get(String url, Map<String,String> params, INetworkCallback<T> callback);
}
