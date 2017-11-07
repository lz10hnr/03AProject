package com.jiyun.a03aproject;

/**
 * Created by xingge on 2017/10/19.
 * 被观察者
 */

public interface Observable {

    //订阅
    void attach(Observer observer);
    //移除订阅
    void detach(Observer observer);
    //发送消息通知
    void notifyMessage(String content);
}
