package com.jiyun.mvc_03a.model.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.mvc_03a.app.App;
import com.jiyun.mvc_03a.model.net.callback.INetworkCallback;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by xingge on 2017/10/20.
 */

public class OKhttpUtils implements IHttp {

    private OkHttpClient okHttpClient;
    //第一步 私有化构造函数
    private OKhttpUtils(){
        okHttpClient = new OkHttpClient.Builder().build();
    }
    //第二步 提供静态的私有的被对象的变量
    private static OKhttpUtils oKhttpUtils;

    //第三步 提供公共的静态的方法，返回值类型是当前类的对象
    public static OKhttpUtils getInstance(){
        if (oKhttpUtils == null) {
            synchronized (OKhttpUtils.class) {
                if (oKhttpUtils == null)
                    oKhttpUtils = new OKhttpUtils();
            }
        }
        return oKhttpUtils;
    }

    @Override
    public <T> void get(String url, Map<String, String> params, final INetworkCallback<T> callback) {

        if(params != null && params.size() > 0){
            //得到所有的key
            Set<String> keys = params.keySet();
            StringBuffer sb = new StringBuffer(url);
            sb.append("?");
            //遍历所有的key
            for (String key : keys){
                //根据key值获取value
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }

            url = sb.substring(0,sb.length()-1);

        }
        //第二步：创建Request对象
        Request request = new Request.Builder().url(url).build();
        //第三步：发送网络请求 同步或者异步请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String jsonData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });
            }
        });
    }

    @Override
    public <T> void get(String url, final INetworkCallback<T> callback) {

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String jsonData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });
            }
        });


    }

    @Override
    public <T> void post(String url, Map<String, String> params, final INetworkCallback<T> callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if(params != null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys){
                String value = params.get(key);
                builder.add(key,value);

            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call,  Response response) throws IOException {

                final String jsonData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
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
        Glide.with(App.context).load(imgUrl).into(imageView);
    }
    /**
     * 自动解析json至回调中的JavaBean
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData,INetworkCallback<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();//得到这个类所实现的所有接口的集合
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();//获取该接口中所有的参数
        Type type = actualTypeArguments[0];//取第一个参数，就是对应JavaBean
        T t = gson.fromJson(jsonData,type);//通过gson转到对应的JavaBean
        return t;
    }

}
