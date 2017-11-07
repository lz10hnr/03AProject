package com.jiyun.mvc_03a.model;

import android.widget.ImageView;

import com.jiyun.mvc_03a.model.net.IHttp;
import com.jiyun.mvc_03a.model.net.callback.INetworkCallback;

import java.io.File;
import java.util.Map;

/**
 * Created by xingge on 2017/10/20.
 */

public class VolleyUtils implements IHttp {

    private VolleyUtils(){}
    private static VolleyUtils volleyUtils = new VolleyUtils();
    public static VolleyUtils getInstance(){
        return volleyUtils;
    }
    @Override
    public <T> void get(String url, Map<String, String> params, INetworkCallback<T> callback) {

    }

    @Override
    public <T> void get(String url, INetworkCallback<T> callback) {

    }

    @Override
    public <T> void post(String url, Map<String, String> params, INetworkCallback<T> callback) {

    }


    @Override
    public <T> void uploadFile(String url, INetworkCallback<T> callback, File... file) {

    }

    @Override
    public <T> void uploadFile(String url, INetworkCallback<T> callback, Map<String, String> params, File... file) {

    }

    @Override
    public <T> void downloadFile(String url, String savePath, INetworkCallback<T> callback) {

    }

    @Override
    public void loadImage(String imgUrl, ImageView imageView) {

    }
}
