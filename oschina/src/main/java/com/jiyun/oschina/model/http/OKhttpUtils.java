package com.jiyun.oschina.model.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.oschina.app.App;
import com.jiyun.oschina.model.callback.INetworkcallback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xingge on 2017/10/27.
 */

public class OKhttpUtils implements IHttp{

    private OkHttpClient okHttpClient;
    private OKhttpUtils(){

        okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            //自定义拦截器 处理请求
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();
                //往请求中添加请求头
                //从请求对象中获取请求对象的builder对象
                Request.Builder builder = request.newBuilder();
                String cookie = getCookie();
                if(!TextUtils.isEmpty(cookie)) {
                    builder.addHeader("Cookie",cookie);
                }
                //重新获取quest对象，根据新的Request对象获取Response对象
                Response response = chain.proceed(builder.build());
                return response;
            }
        }).addInterceptor(new Interceptor() {
            //自定义拦截器  处理响应
            @Override
            public Response intercept(Chain chain) throws IOException {
                //得到请求的Request对象
                Request request = chain.request();
                //服务器返回的响应
                Response response = chain.proceed(request);
                //获取响应头
                Headers headers = response.headers();
                //获取响应头中的所有key,value值
                Set<String> names = headers.names();
                String cookie = "";
                for (String key : names){
                    String value = headers.get(key);
                    if("Set-Cookie".equals(key)){
                        //多个Set-Cookie以分号进行分割
                        cookie = cookie + value+";";
                    }
                }
                //去除最后一个分号
                if(cookie.length() > 0)
                    cookie = cookie.substring(0,cookie.length()-1);
                //持久化存储cookie至本地
                saveCookie(cookie);
                return response;
            }
        }).build();
    }
    private static OKhttpUtils oKhttpUtils;
    public static OKhttpUtils getInstance(){
        if(oKhttpUtils == null)
            synchronized (OKhttpUtils.class) {
                if (oKhttpUtils == null)
                    oKhttpUtils = new OKhttpUtils();
            }
        return oKhttpUtils;
    }

    @Override
    public void get(String url, Map<String, String> params, final INetworkcallback networkcallback) {

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
            public void onFailure(Call call, final IOException e) {

                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        networkcallback.onError("666",e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String xmlData = response.body().string();

                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        networkcallback.onSuccess(xmlData);
                    }
                });

            }
        });
    }

    @Override
    public void get(String url, final INetworkcallback networkcallback) {

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        networkcallback.onError("666",e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String xmlData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        networkcallback.onSuccess(xmlData);
                    }
                });


            }
        });

    }

    @Override
    public void post(String url, Map<String, String> params, final INetworkcallback networkcallback) {

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
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        networkcallback.onError("666",e.getMessage());
                    }
                });

            }

            @Override
            public void onResponse(Call call,  Response response) throws IOException {

                final String xmlData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        networkcallback.onSuccess(xmlData);
                    }
                });



            }
        });
    }

    @Override
    public void loadImage(String imgUrl, ImageView imageView) {
        Glide.with(App.context).load(imgUrl).into(imageView);
    }

    private void saveCookie(String cookie){
        SharedPreferences preferences = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Cookie",cookie);
        editor.commit();
    }

    private String getCookie(){
        SharedPreferences preferences = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String cookie = preferences.getString("Cookie", "");
        return cookie;
    }

}
