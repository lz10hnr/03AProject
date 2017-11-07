package com.jiyun.a03aproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingge on 2017/10/19.
 * 被观察者具体的实现类，用于管理所有的观察者
 */

public class ObservalbeManager implements Observable {

    private ObservalbeManager(){}
    private static ObservalbeManager observalbeManager = new ObservalbeManager();
    public static ObservalbeManager getInstance(){
        return observalbeManager;
    }


    //用于存放所有的观察者
    private List<Observer> observers = new ArrayList<>();

    /**
     * 订阅  用于存储记录订阅的观察者
     * @param observer 要订阅消息的观察者
     */
    @Override
    public void attach(Observer observer) {

        observers.add(observer);
    }

    /**
     * 取消订阅的方法
     * @param observer 要取消订阅的观察者对象
     */
    @Override
    public void detach(Observer observer) {

        observers.remove(observer);
    }

    /**
     * 用于内容更新是通知所有观察者
     * @param content 通知的内容
     */
    @Override
    public void notifyMessage(String content) {

        for (Observer observer : observers){
            //循环遍历所有的观察者，然后调用其接受消息的方法
            observer.update(content);
        }
    }
}
