package com.jiyun.oschina.module.home.view;

import com.jiyun.oschina.model.entity.Blog;
import com.jiyun.oschina.model.entity.Home;

import java.util.List;

/**
 * Created by xingge on 2017/11/1.
 */

public interface IHomeItemView {

    //抽取了四个显示数据的方法，显示对应Fragment加载的数据
    void showNews(List<Home.NewsBean> newsData);
    void showHots(List<Home.NewsBean> hotsData);
    void showBlogs(List<Blog.BlogBean> blogData);
    void showTJs(List<Blog.BlogBean> tjData);

}
