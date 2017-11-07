package com.jiyun.mvc_03a.model.net;

import android.widget.ImageView;

import com.jiyun.mvc_03a.model.net.callback.INetworkCallback;

import java.io.File;
import java.util.Map;

/**
 * Created by xingge on 2017/10/20.
 */

public interface IHttp {

    /**
     * 发送get请求
     * @param url 接口地址
     * @param params 传递的参数
     * @param callback 接口回调
     */
    <T> void get(String url, Map<String,String> params, INetworkCallback<T> callback);

    /**
     * get请求无参
     * @param url 接口地址
     * @param callback 接口回调
     */
    <T> void get(String url,INetworkCallback<T> callback);

    /**
     * 发送post请求
     * @param url 接口地址
     * @param params 传递的参数
     * @param callback 接口回调
     */
    <T> void post(String url, Map<String,String> params, INetworkCallback<T> callback);

    /**
     * post请求无参
     * @param url 接口地址
     * @param callback 接口回调
     */
//    void post(String url,INetworkCallback callback);

    /**
     * 文件上传的方法
     * @param url 上传的地址
     * @param file 要上传的文件
     * @param callback 接口回调
     */
    <T> void uploadFile(String url,INetworkCallback<T> callback, File... file);
    /**
     * 文件上传的方法
     * @param url 上传的地址
     * @param file 要上传的文件
     * @param params 参数列表
     * @param callback 接口回调
     */
    <T> void uploadFile(String url, INetworkCallback<T> callback, Map<String,String> params, File... file);

    /**
     * 文件下载的方法
     * @param url 文件地址
     * @param savePath 保存路径
     * @param callback 接口回调
     */
    <T> void downloadFile(String url,String savePath,INetworkCallback<T> callback);

    /**
     * 加载图片的方法
     * @param imgUrl 图片地址
     * @param imageView 加载图片的imageView
     */
    void loadImage(String imgUrl, ImageView imageView);

}
