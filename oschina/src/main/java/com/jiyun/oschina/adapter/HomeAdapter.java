package com.jiyun.oschina.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.jiyun.oschina.R;
import com.jiyun.oschina.base.BaseFragment;
import com.jiyun.oschina.model.entity.Home;

import java.util.List;

/**
 * Created by xingge on 2017/10/30.
 */

public class HomeAdapter extends FragmentPagerAdapter{

    private List<BaseFragment> fragments;
    private List<String> titiles;
    public HomeAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titiles) {
        super(fm);
        this.fragments = fragments;
        this.titiles = titiles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titiles.get(position);
    }
}
