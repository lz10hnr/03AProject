package com.jiyun.mvp_03a.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jiyun.mvp_03a.app.App;
import com.jiyun.mvp_03a.model.biz.IMineModel;
import com.jiyun.mvp_03a.model.biz.MineModel;
import com.jiyun.mvp_03a.model.entity.UserInfo;
import com.jiyun.mvp_03a.model.net.callback.INetworkCallback;
import com.jiyun.mvp_03a.view.IMineView;

/**
 * Created by xingge on 2017/10/24.
 *
 * p层通常持有model和View两个对象
 */

public class MinePresenter implements IMinePresenter {

    private IMineModel mineModel;
    private IMineView mineView;
    public MinePresenter(IMineView mineView){
        mineModel = new MineModel();
        this.mineView = mineView;
    }

    @Override
    public void login(String username, String pwd, String keep_login) {

        if(!checkUserName(username))
            return;
        if(!checkPwd(pwd))
            return;
        if(!checkNetWork())

        mineView.showProgressDialog();

            mineModel.login(username, pwd, keep_login, new INetworkCallback<UserInfo>() {
                @Override
                public void onSuccess(UserInfo userInfo) {

                    mineView.toMainActivity();
                    mineView.dimissProgressDialog();

                }

                @Override
                public void onError(String errorCode, String msg) {

                    mineView.showErrorMsg("登录失败");
                    mineView.dimissProgressDialog();
                }
            });

    }

    @Override
    public boolean checkUserName(String userName) {
        if(userName == null || "".equals(userName)) {
            mineView.showErrorMsg("用户名不能为空");
            return false;
        }
        if(userName.length() < 6) {
            mineView.showErrorMsg("用户名长度必须大于6位");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPwd(String pwd) {
        if(pwd == null || "".equals(pwd)) {
            mineView.showErrorMsg("密码不能为空");
            return false;
        }
        if(pwd.length() < 6) {
            mineView.showErrorMsg("密码长度必须大于6位");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkNetWork() {

        ConnectivityManager mConnectivityManager = (ConnectivityManager)
                App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            if (mNetworkInfo.isAvailable())
                return true;
            else
                mineView.showErrorMsg("wangluobutong");
        }
        return false;
    }
}
