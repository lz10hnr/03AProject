package com.jiyun.mvp_03a.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.mvp_03a.app.App;

import butterknife.ButterKnife;

/**
 * Created by xingge on 2017/10/24.
 */

public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        App.context = this;
        init();
        loadData();
    }

    protected abstract int getLayoutId();
    protected abstract void init();
    protected abstract void loadData();

}
