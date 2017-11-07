package com.jiyun.mvp_03a.presenter;

import com.jiyun.mvp_03a.model.biz.HomeModel;
import com.jiyun.mvp_03a.model.biz.IHomeModel;
import com.jiyun.mvp_03a.model.entity.ChinaLive;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;
import com.jiyun.mvp_03a.view.IHomeView;

/**
 * Created by xingge on 2017/10/25.
 */

public class HomePresenter implements IHomePresenter {


    private IHomeModel homeModel;
    private IHomeView homeView;
    public HomePresenter(IHomeView homeView){
        this.homeModel = new HomeModel();
        this.homeView = homeView;
    }

    @Override
    public void chinaLive() {

        homeView.showProgressBar();

        homeModel.chinaLive(new INetworkCallback<ChinaLive>() {
            @Override
            public void onSuccess(ChinaLive chinaLive) {

                homeView.loadMore(chinaLive.getTablist());
                homeView.dimiss();
            }

            @Override
            public void onError(String errorCode, String msg) {

                homeView.showErrorMsg(msg);
                homeView.dimiss();
            }
        });
    }

    @Override
    public void refersh() {
        homeView.showProgressBar();

        homeModel.chinaLive(new INetworkCallback<ChinaLive>() {
            @Override
            public void onSuccess(ChinaLive chinaLive) {

                homeView.refersh(chinaLive.getTablist());
                homeView.dimiss();
            }

            @Override
            public void onError(String errorCode, String msg) {

                homeView.showErrorMsg(msg);
                homeView.dimiss();
            }
        });
    }
}
