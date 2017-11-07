package com.jiyun.mvc_03a.model.biz;

import com.jiyun.mvc_03a.model.net.callback.INetworkCallback;

import java.util.HashMap;

/**
 * Created by xingge on 2017/10/20.
 */

public interface IHomeModel {
    //获取首页数据
    //业务方法里面应该传递哪些参数：总共就分为两种：1、接口文档中的参数列表2、接口回调
    <T> void loadHomeList(String key, int pno, INetworkCallback<T> callback);

    <T> void loadHomeBanner(INetworkCallback<T> callback);
}
