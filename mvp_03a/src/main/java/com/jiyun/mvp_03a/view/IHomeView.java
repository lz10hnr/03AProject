package com.jiyun.mvp_03a.view;

import com.jiyun.mvp_03a.model.entity.ChinaLive;

import java.util.List;

/**
 * Created by xingge on 2017/10/25.
 */

public interface IHomeView {

    void showProgressBar();

    void dimiss();

    /**
     * 刷新数据列表
     * @param homeData
     */
    void refersh(List<ChinaLive.TablistBean> homeData);

    /**
     * 加载更多
     * @param homeData
     */
    void loadMore(List<ChinaLive.TablistBean> homeData);

    /**
     * 点击item跳转至详情页
     */
    void toHomeDetail();

    /**
     * 网络加载失败 提示失败信息
     */
    void showErrorMsg(String errorMsg);
}
