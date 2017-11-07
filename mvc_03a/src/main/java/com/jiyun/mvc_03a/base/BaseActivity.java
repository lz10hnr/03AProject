package com.jiyun.mvc_03a.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.mvc_03a.app.App;

import butterknife.ButterKnife;

/**
 * Created by xingge on 2017/10/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.context = this;
        ButterKnife.bind(this);
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


}
