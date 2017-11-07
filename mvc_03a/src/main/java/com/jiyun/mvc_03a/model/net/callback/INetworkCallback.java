package com.jiyun.mvc_03a.model.net.callback;

/**
 * Created by xingge on 2017/10/20.
 */

public interface INetworkCallback<T> {

    /**
     * 网络请求成功的回调方法
     * @param t 服务器返回的JavaBean
     */
    void onSuccess(T t);

    /**
     * 网络请求失败的接口回调
     * @param errorMsg
     */
    void onError(String errorMsg);
}
