package com.jiyun.oschina.presenter;

/**
 * Created by xingge on 2017/11/3.
 */

public interface IMinePresenter  {

    //桥梁方法
    void login(String username, String pwd);
    void userInfo(String uid);
    //业务逻辑判断的方法
    boolean checkUserName(String userName);
    boolean checkPwd(String pwd);
}
