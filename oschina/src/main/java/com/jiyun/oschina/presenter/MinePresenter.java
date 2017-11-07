package com.jiyun.oschina.presenter;

import android.util.Log;

import com.jiyun.oschina.model.biz.IMineModel;
import com.jiyun.oschina.model.biz.MineModel;
import com.jiyun.oschina.model.callback.INetworkcallback;
import com.jiyun.oschina.model.entity.UserInfo;
import com.jiyun.oschina.module.mine.view.IMineView;
import com.thoughtworks.xstream.XStream;

/**
 * Created by xingge on 2017/11/3.
 */

public class MinePresenter implements IMinePresenter {

    private IMineModel mineModel;
    private IMineView mineView;
    public MinePresenter(IMineView mineView){
        mineModel = new MineModel();
        this.mineView = mineView;
    }

    @Override
    public void login(String username, String pwd) {

        if(!checkUserName(username)){
            return;
        }
        if(!checkPwd(pwd)){
            return;
        }

        mineModel.login(username, pwd, new INetworkcallback() {
            @Override
            public void onSuccess(String xmlData) {

                XStream xStream = new XStream();
                xStream.alias("oschina", UserInfo.class);
                xStream.alias("user",UserInfo.UserBean.class);
                UserInfo userInfo = (UserInfo) xStream.fromXML(xmlData);
                mineView.showUserInfo(userInfo);
            }

            @Override
            public void onError(String errorCode, String errorMsg) {

                mineView.showMessage(errorMsg);
            }
        });
    }

    @Override
    public void userInfo(String uid) {
        mineModel.getUserInfo(uid, new INetworkcallback() {
            @Override
            public void onSuccess(String xmlData) {
                Log.d("MinePresenter", xmlData);
            }

            @Override
            public void onError(String errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public boolean checkUserName(String userName) {
        return true;
    }

    @Override
    public boolean checkPwd(String pwd) {
        return true;
    }


}
