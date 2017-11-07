package com.jiyun.mvp_03a.model.biz;

import com.jiyun.mvp_03a.model.entity.ChinaLive;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;

/**
 * Created by xingge on 2017/10/25.
 */

public interface IHomeModel {

    void chinaLive(INetworkCallback<ChinaLive> callback);
}
