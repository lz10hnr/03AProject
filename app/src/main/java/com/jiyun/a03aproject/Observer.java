package com.jiyun.a03aproject;

/**
 * Created by xingge on 2017/10/19.
 * 观察者  用于接收通知的
 */
public interface Observer {
    //接收通知的方法
    void update(String content);
}
