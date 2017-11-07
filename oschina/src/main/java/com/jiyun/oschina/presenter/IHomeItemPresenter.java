package com.jiyun.oschina.presenter;

/**
 * Created by xingge on 2017/11/1.
 */

public interface IHomeItemPresenter {
    //四个业务方法 加载ViewPager对应的四个Fragment的数据
    void news(String catalog, int pageIndex, int pageSize);
    void hot(String catalog, int pageIndex, int pageSize);
    void blog(String type, int pageIndex, int pageSize);
    void tuijian(String type, int pageIndex, int pageSize);
}
