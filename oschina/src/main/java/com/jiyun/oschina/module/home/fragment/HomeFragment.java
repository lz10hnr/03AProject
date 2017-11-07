package com.jiyun.oschina.module.home.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.oschina.R;
import com.jiyun.oschina.adapter.HomeAdapter;
import com.jiyun.oschina.base.BaseFragment;
import com.jiyun.oschina.model.entity.Blog;
import com.jiyun.oschina.model.entity.Home;
import com.jiyun.oschina.module.home.view.IHomeView;
import com.jiyun.oschina.presenter.HomePresenter;
import com.jiyun.oschina.presenter.IHomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/10/27.
 */

public class HomeFragment extends BaseFragment implements IHomeView {

    @BindView(R.id.homeTitle)
    TabLayout homeTitle;
    @BindView(R.id.homeViewPager)
    ViewPager homeViewPager;
    private IHomePresenter homePresenter;
    private HomeAdapter adapter;
    private List<BaseFragment> fragments;
    private List<String> titiles;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init() {
        homePresenter = new HomePresenter(this);
        fragments = new ArrayList<>();
        titiles = new ArrayList<>();
        adapter = new HomeAdapter(getChildFragmentManager(),fragments,titiles);
        homeViewPager.setAdapter(adapter);
        homeTitle.setTabMode(TabLayout.MODE_FIXED);
        homeTitle.setupWithViewPager(homeViewPager);
    }

    @Override
    protected void loadData() {

        homePresenter.doHomeTitle();

    }


    @Override
    public void showHomeData(List<String> titles) {

        this.titiles.addAll(titles);
        for (int i = 0; i < this.titiles.size(); i++){
            HomeItemFragment homeItemFragment = new HomeItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title",this.titiles.get(i));
            homeItemFragment.setArguments(bundle);
            fragments.add(homeItemFragment);
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }


}
