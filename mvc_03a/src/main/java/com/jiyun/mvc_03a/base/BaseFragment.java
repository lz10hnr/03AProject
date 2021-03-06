package com.jiyun.mvc_03a.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xingge on 2017/10/20.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        loadData();
    }

    /**
     * 用于加载Activity布局
     * @return
     */
    protected abstract int getLayoutId();
    /**
     * 统一管理数据的初始化
     */
    protected abstract void init();

    /**
     * 统一做数据加载
     */
    protected abstract void loadData();


    /**
     * 当Fragment隐藏、显示时改方法会被调用
     * @param hidden 当Fragment被隐藏时为true
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden)
            onHide();
        else
            onShow();
    }

    /**
     * 当Fragment可见时调用  可以在该方法中可以做数据刷新的操作
     */
    protected void onShow(){};

    /**
     * 当Fragment不可见时调用  可以做一下资源释放的操作
     */
    protected void onHide(){};
}
