package com.jiyun.oschina.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

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

public class BFragment extends BaseFragment {
    @BindView(R.id.strartDFragment)
    Button strartDFragment;
    @BindView(R.id.cFragmentContainer)
    FrameLayout cFragmentContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.b_fragment;
    }

    @Override
    protected void init() {

        ((BaseActivity)getActivity()).changFragment(R.id.cFragmentContainer,CFragment.class,null,false,false);

    }

    @Override
    protected void loadData() {

    }

    @OnClick(R.id.strartDFragment)
    public void onViewClicked() {

        ((BaseActivity)getActivity()).changFragment(R.id.container,DFragment.class,null,false,true);

    }
}
