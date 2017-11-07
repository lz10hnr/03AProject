package com.jiyun.oschina.presenter;

import com.jiyun.oschina.model.biz.HomeModel;
import com.jiyun.oschina.model.biz.IHomeModel;
import com.jiyun.oschina.model.callback.INetworkcallback;
import com.jiyun.oschina.model.entity.Blog;
import com.jiyun.oschina.model.entity.Home;
import com.jiyun.oschina.module.home.view.IHomeView;
import com.thoughtworks.xstream.XStream;

import java.util.List;

/**
 * Created by xingge on 2017/10/27.
 */

public class HomePresenter implements IHomePresenter {

    private IHomeModel homeModel;
    private IHomeView homeView;
    public HomePresenter(IHomeView homeView){
        homeModel = new HomeModel();
        this.homeView = homeView;
    }



    @Override
    public void doHomeTitle() {
        List<String> titles = homeModel.doHomeTitle();
        homeView.showHomeData(titles);
    }
}
