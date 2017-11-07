package com.jiyun.mvp_03a.presenter;

/**
 * Created by xingge on 2017/10/24.
 *
 * p层两种作用：1、充当View层和model层数据交互的桥梁 2、业务逻辑判断
 */

public interface IMinePresenter {
    //桥梁方法  跟model方法名一致 并且参数列表一致 唯一不同 没有接口回调
    void login(String username, String pwd, String keep_login);

    //业务逻辑判断

    //检查用户名是否合法
    boolean checkUserName(String userName);

    //检查密码是否合法
    boolean checkPwd(String pwd);

    boolean checkNetWork();
}
