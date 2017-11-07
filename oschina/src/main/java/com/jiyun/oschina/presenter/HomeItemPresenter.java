package com.jiyun.oschina.presenter;

import com.jiyun.oschina.model.biz.HomeModel;
import com.jiyun.oschina.model.biz.IHomeModel;
import com.jiyun.oschina.model.callback.INetworkcallback;
import com.jiyun.oschina.model.entity.Blog;
import com.jiyun.oschina.model.entity.Home;
import com.jiyun.oschina.module.home.view.IHomeItemView;
import com.thoughtworks.xstream.XStream;

/**
 * Created by xingge on 2017/11/1.
 */

public class HomeItemPresenter implements IHomeItemPresenter {

    private IHomeItemView iHomeItemView;
    private IHomeModel homeModel;
    public HomeItemPresenter(IHomeItemView iHomeItemView){
        this.iHomeItemView = iHomeItemView;
        this.homeModel = new HomeModel();
    }

    @Override
    public void news(String catalog, int pageIndex, int pageSize) {
        homeModel.news(catalog,pageIndex,pageSize,null,new INetworkcallback(){

            @Override
            public void onSuccess(String xmlData) {

                XStream xStream = new XStream();
                xStream.alias("oschina",Home.class);
                xStream.alias("news",Home.NewsBean.class);
                Home home = (Home) xStream.fromXML(xmlData);
                iHomeItemView.showNews(home.getNewslist());

            }

            @Override
            public void onError(String errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void hot(String catalog, int pageIndex, int pageSize) {
        homeModel.news(catalog,pageIndex,pageSize,"week",new INetworkcallback(){

            @Override
            public void onSuccess(String xmlData) {
                XStream xStream = new XStream();
                xStream.alias("oschina",Home.class);
                xStream.alias("news",Home.NewsBean.class);
                Home home = (Home) xStream.fromXML(xmlData);
                iHomeItemView.showHots(home.getNewslist());
            }

            @Override
            public void onError(String errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void blog(String type, int pageIndex, int pageSize) {

        homeModel.blog(type, pageIndex, pageSize, new INetworkcallback() {
            @Override
            public void onSuccess(String xmlData) {

                XStream xStream = new XStream();
                xStream.alias("oschina",Blog.class);
                xStream.alias("blog",Blog.BlogBean.class);
                Blog blog = (Blog) xStream.fromXML(xmlData);
            }

            @Override
            public void onError(String errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void tuijian(String type, int pageIndex, int pageSize) {

        homeModel.blog(type, pageIndex, pageSize, new INetworkcallback() {
            @Override
            public void onSuccess(String xmlData) {

                XStream xStream = new XStream();
                xStream.alias("oschina",Blog.class);
                xStream.alias("blog",Blog.BlogBean.class);
                Blog blog = (Blog) xStream.fromXML(xmlData);
            }

            @Override
            public void onError(String errorCode, String errorMsg) {

            }
        });
    }
}
