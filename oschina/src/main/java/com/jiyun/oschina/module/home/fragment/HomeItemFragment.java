package com.jiyun.oschina.module.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.jiyun.oschina.R;
import com.jiyun.oschina.adapter.HomeNewsItemAdapter;
import com.jiyun.oschina.base.BaseFragment;
import com.jiyun.oschina.model.biz.HomeModel;
import com.jiyun.oschina.model.biz.IHomeModel;
import com.jiyun.oschina.model.entity.Blog;
import com.jiyun.oschina.model.entity.Home;
import com.jiyun.oschina.module.home.view.IHomeItemView;
import com.jiyun.oschina.module.home.view.IHomeView;
import com.jiyun.oschina.presenter.HomeItemPresenter;
import com.jiyun.oschina.presenter.HomePresenter;
import com.jiyun.oschina.presenter.IHomeItemPresenter;
import com.jiyun.oschina.presenter.IHomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/11/1.
 */

public class HomeItemFragment extends BaseFragment implements IHomeItemView{

    @BindView(R.id.mHomeItemRecyclerView)
    PullToRefreshRecyclerView mHomeItemRecyclerView;

    private IHomeItemPresenter homePresenter;
    private HomeNewsItemAdapter newsItemAdaper;
    private HomeNewsItemAdapter hotItemAdaper;
    private List<Home.NewsBean> newsDatas;
    private List<Home.NewsBean> hotDatas;

    @Override
    protected int getLayoutId() {
        return R.layout.home_item_fragment;
    }

    @Override
    protected void init() {
        homePresenter = new HomeItemPresenter(this);
        newsDatas = new ArrayList<>();
        hotDatas = new ArrayList<>();
        newsItemAdaper = new HomeNewsItemAdapter(getActivity(),newsDatas);
        hotItemAdaper = new HomeNewsItemAdapter(getActivity(),hotDatas);
        mHomeItemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void loadData() {
        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        switch (title){
            case "资讯":
                mHomeItemRecyclerView.setAdapter(newsItemAdaper);
                homePresenter.news("1",1,10);
                break;
            case "热点":
                mHomeItemRecyclerView.setAdapter(hotItemAdaper);
                homePresenter.hot("4",1,10);
                break;
            case "博客":
                homePresenter.blog("latest",1,10);
                break;
            case "推荐":
                homePresenter.blog("recommend",1,10);
                break;
        }
    }

    /**
     * 当Fragment在ViewPager中加载时该方法才会被调用
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Bundle bundle = getArguments();
            String title = bundle.getString("title");
            switch (title){
                case "资讯":
                    if (newsItemAdaper != null)
                        newsItemAdaper.notifyDataSetChanged();
                    break;
                case "热点":
                    if (hotItemAdaper != null)
                        hotItemAdaper.notifyDataSetChanged();
                    break;
                case "博客":
                    break;
                case "推荐":

                    break;
            }

        }
    }


    @Override
    public void showNews(List<Home.NewsBean> newsData) {

        this.newsDatas.addAll(newsData);
        newsItemAdaper.notifyDataSetChanged();
    }

    @Override
    public void showHots(List<Home.NewsBean> hotsData) {

        this.hotDatas.addAll(hotsData);
        newsItemAdaper.notifyDataSetChanged();

    }

    @Override
    public void showBlogs(List<Blog.BlogBean> blogData) {

    }

    @Override
    public void showTJs(List<Blog.BlogBean> tjData) {

    }
}
