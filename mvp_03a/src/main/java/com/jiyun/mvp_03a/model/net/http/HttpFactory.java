package com.jiyun.mvp_03a.model.net.http;

/**
 * Created by xingge on 2017/10/24.
 */

public class HttpFactory {

    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
}
