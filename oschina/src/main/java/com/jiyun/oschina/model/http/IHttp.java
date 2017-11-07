package com.jiyun.oschina.model.http;

import android.widget.ImageView;

import com.jiyun.oschina.model.callback.INetworkcallback;

import java.util.Map;

/**
 * Created by xingge on 2017/10/27.
 */

public interface IHttp {


    void get(String url, Map<String,String> params, INetworkcallback networkcallback);

    void get(String url, INetworkcallback networkcallback);

    void post(String url, Map<String,String> params, INetworkcallback networkcallback);

    void loadImage(String imgUrl, ImageView imageView);
}
