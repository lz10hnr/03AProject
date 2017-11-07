package com.jiyun.mvc_03a.model;

import com.jiyun.mvc_03a.model.net.IHttp;
import com.jiyun.mvc_03a.model.net.OKhttpUtils;

/**
 * Created by xingge on 2017/10/20.
 */

public class HttpFactory {

    public static IHttp create(){
        return OKhttpUtils.getInstance();
    }
}
