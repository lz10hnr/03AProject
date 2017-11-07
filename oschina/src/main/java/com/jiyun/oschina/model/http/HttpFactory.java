package com.jiyun.oschina.model.http;

/**
 * Created by xingge on 2017/10/27.
 */

public class HttpFactory {

    public static IHttp getIntance(){
        return OKhttpUtils.getInstance();
    }
}
