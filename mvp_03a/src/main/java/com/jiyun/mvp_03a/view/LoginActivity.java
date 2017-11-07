package com.jiyun.mvp_03a.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jiyun.mvp_03a.R;
import com.jiyun.mvp_03a.base.BaseActivity;
import com.jiyun.mvp_03a.presenter.IMinePresenter;
import com.jiyun.mvp_03a.presenter.MinePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements IMineView{


    @BindView(R.id.userNameEt)
    EditText userNameEt;
    @BindView(R.id.pwdEt)
    EditText pwdEt;
    @BindView(R.id.loginBtn)
    Button loginBtn;

    ProgressDialog progressDialog;

    private IMinePresenter minePresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        minePresenter = new MinePresenter(this);
    }

    @Override
    protected void loadData() {

    }


    @OnClick(R.id.loginBtn)
    public void onViewClicked() {
        minePresenter.login(userNameEt.getText().toString(),pwdEt.getText().toString(),"1");
    }

    @Override
    public void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.show();

    }

    @Override
    public void dimissProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showErrorMsg(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMainActivity() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
