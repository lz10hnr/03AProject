package com.jiyun.oschina.module.mine.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jiyun.oschina.R;
import com.jiyun.oschina.base.BaseFragment;
import com.jiyun.oschina.model.entity.UserInfo;
import com.jiyun.oschina.module.mine.view.IMineView;
import com.jiyun.oschina.presenter.IMinePresenter;
import com.jiyun.oschina.presenter.MinePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/10/27.
 */

public class MineFragment extends BaseFragment implements IMineView {

    @BindView(R.id.userNameEt)
    EditText userNameEt;
    @BindView(R.id.pwdEt)
    EditText pwdEt;
    @BindView(R.id.loginBtn)
    Button loginBtn;

    private IMinePresenter minePresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void init() {

        minePresenter = new MinePresenter(this);
    }

    @Override
    protected void loadData() {


    }

    @Override
    protected void onShow() {
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showUserInfo(UserInfo userInfo) {

        minePresenter.userInfo(userInfo.getUser().getUid());
        Log.d("MineFragment", userInfo.getUser().getUid());
    }

    @OnClick(R.id.loginBtn)
    public void onViewClicked() {
        minePresenter.login(userNameEt.getText().toString().trim(),pwdEt.getText().toString().trim());
    }
}
