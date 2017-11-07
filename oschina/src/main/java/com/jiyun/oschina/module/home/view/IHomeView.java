package com.jiyun.oschina.module.home.view;

import com.jiyun.oschina.model.entity.Blog;
import com.jiyun.oschina.model.entity.Home;

import java.util.List;

/**
 * Created by xingge on 2017/10/27.
 */

public interface IHomeView {

    void showHomeData(List<String> titles);

    void showErrorMsg(String errorMsg);



}
