package com.jiyun.oschina.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jiyun.oschina.R;
import com.jiyun.oschina.base.BaseActivity;
import com.jiyun.oschina.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/10/30.
 */

public class AFragment extends BaseFragment {
    @BindView(R.id.strartBFragment)
    Button strartBFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.a_fragment;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick(R.id.strartBFragment)
    public void onViewClicked() {

        ((BaseActivity)getActivity()).changFragment(R.id.container,BFragment.class,null,false,true);

    }
}
