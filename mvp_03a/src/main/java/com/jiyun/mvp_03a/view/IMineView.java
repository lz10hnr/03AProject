package com.jiyun.mvp_03a.view;

/**
 * Created by xingge on 2017/10/24.
 *
 * view层的接口如何抽取？
 * 抽取的是一切人眼睛能看到的变化
 */
public interface IMineView {
    void showProgressDialog();
    void dimissProgressDialog();
    void showErrorMsg(String msg);
    void toMainActivity();
}
