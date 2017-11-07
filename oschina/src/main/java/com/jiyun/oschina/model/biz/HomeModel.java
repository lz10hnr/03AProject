package com.jiyun.oschina.model.biz;

import com.jiyun.oschina.config.Urls;
import com.jiyun.oschina.model.callback.INetworkcallback;
import com.jiyun.oschina.model.http.HttpFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xingge on 2017/10/27.
 */

public class HomeModel implements IHomeModel {

    @Override
    public void news(String catalog, int pageIndex, int pageSize,String show, INetworkcallback networkcallback) {
        Map<String,String> params = new HashMap<>();
        params.put("catalog",catalog);
        params.put("pageIndex",pageIndex+"");
        params.put("pageSize",pageSize+"");
        if(show != null && show.trim().length() > 0)
            params.put("show",show);
        HttpFactory.getIntance().get(Urls.NEWS,params,networkcallback);
    }

    @Override
    public void blog(String type, int pageIndex, int pageSize, INetworkcallback networkcallback) {

        Map<String,String> params = new HashMap<>();
        params.put("type",type);
        params.put("pageIndex",pageIndex+"");
        params.put("pageSize",pageSize+"");
        HttpFactory.getIntance().get(Urls.BOLG,params,networkcallback);

    }

    @Override
    public List<String> doHomeTitle() {
        List<String> titles = new ArrayList<>();
        titles.add("资讯");
        titles.add("热点");
        titles.add("博客");
        titles.add("推荐");
        return titles;
    }
}
