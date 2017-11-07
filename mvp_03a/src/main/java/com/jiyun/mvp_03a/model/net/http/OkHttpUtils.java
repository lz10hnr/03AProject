package com.jiyun.mvp_03a.model.net.http;

import com.bumptech.glide.util.Util;
import com.google.gson.Gson;
import com.jiyun.mvp_03a.app.App;
import com.jiyun.mvp_03a.model.entity.UserInfo;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xingge on 2017/10/24.
 */

public class OkHttpUtils implements IHttp {


    private OkHttpClient okHttpClient;
    private OkHttpUtils(){

        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static OkHttpUtils okHttpUtils;

    public static OkHttpUtils getInstance(){

        if(okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;

    }

    @Override
    public <T> void get(String url, Map<String, String> params, final INetworkCallback<T> callback) {
        if (params != null && params.size() > 0) {
            StringBuffer sb = new StringBuffer(url);
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError("500", e.getMessage());
                    }

                });

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {

                final String resultData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        XStream stream=new XStream();
//                        stream.alias("oschina",UserInfo.class);
//                        stream.alias("user", UserInfo.UserBean.class);
//                        UserInfo uerInfo = (UserInfo) stream.fromXML(resultData);
//                        if(uerInfo.getUser() == null)
//                            callback.onError(uerInfo.getResult().getErrorCode(),uerInfo.getResult().getErrorMessage());
//                        else
//                            callback.onSuccess((T) uerInfo);

                        callback.onSuccess(getGeneric(resultData, callback));
                    }
                });


            }
        });
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
