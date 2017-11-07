package com.jiyun.mvp_03a.model.biz;

import com.jiyun.mvp_03a.config.Uris;
import com.jiyun.mvp_03a.model.entity.ChinaLive;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;
import com.jiyun.mvp_03a.model.net.http.HttpFactory;

/**
 * Created by xingge on 2017/10/25.
 */

public class HomeModel implements IHomeModel {
    @Override
    public void chinaLive(INetworkCallback<ChinaLive> callback) {
        HttpFactory.create().get(Uris.CHINALIVE,null,callback);
    }
}
