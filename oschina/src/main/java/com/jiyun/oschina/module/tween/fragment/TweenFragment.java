package com.jiyun.oschina.module.tween.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jiyun.oschina.R;
import com.jiyun.oschina.base.BaseActivity;
import com.jiyun.oschina.base.BaseFragment;
import com.jiyun.oschina.test.AFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/10/27.
 */

public class TweenFragment extends BaseFragment {

    @BindView(R.id.starAFragment)
    Button starAFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.tween_fragment;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @OnClick(R.id.starAFragment)
    public void onViewClicked() {

//        (R.id.container, AFragment.class,null,true,false);
    }

    @Override
    protected void onShow() {
        super.onShow();
    }
}
