package com.jiyun.oschina.model.biz;

import com.jiyun.oschina.model.callback.INetworkcallback;

import java.util.List;

/**
 * Created by xingge on 2017/10/27.
 */

public interface IHomeModel {

    //获取资讯和热点的业务方法
    void news(String catalog, int pageIndex, int pageSize, String show, INetworkcallback networkcallback);

    //博客和推荐的业务方法
    void blog(String type, int pageIndex, int pageSize, INetworkcallback networkcallback);

    //自定义加标题数据抽取的业务方法
    List<String> doHomeTitle();
}
