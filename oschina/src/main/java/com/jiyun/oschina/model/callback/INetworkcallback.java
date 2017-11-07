package com.jiyun.oschina.model.callback;

/**
 * Created by xingge on 2017/10/27.
 */

public interface INetworkcallback {

    void onSuccess(String xmlData);
    void onError(String errorCode,String errorMsg);
}
