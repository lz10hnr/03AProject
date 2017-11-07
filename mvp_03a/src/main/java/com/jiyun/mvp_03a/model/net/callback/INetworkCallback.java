package com.jiyun.mvp_03a.model.net.callback;

/**
 * Created by xingge on 2017/10/24.
 */

public interface INetworkCallback<T> {

    void onSuccess(T t);
    void onError(String errorCode,String msg);

}
