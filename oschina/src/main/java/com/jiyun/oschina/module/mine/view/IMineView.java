package com.jiyun.oschina.module.mine.view;

import com.jiyun.oschina.model.entity.UserInfo;

/**
 * Created by xingge on 2017/11/3.
 */

public interface IMineView {

    void showMessage(String msg);
    void showUserInfo(UserInfo userInfo);
}
