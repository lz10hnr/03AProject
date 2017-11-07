package com.jiyun.mvp_03a.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.mvp_03a.R;
import com.jiyun.mvp_03a.adapter.HomeListAdapter;
import com.jiyun.mvp_03a.base.BaseActivity;
import com.jiyun.mvp_03a.model.entity.ChinaLive;
import com.jiyun.mvp_03a.presenter.HomePresenter;
import com.jiyun.mvp_03a.presenter.IHomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements IHomeView{


    @BindView(R.id.mHomeList)
    PullToRefreshRecyclerView mHomeList;

    private IHomePresenter homePresenter;
    private List<ChinaLive.TablistBean> homeDatas;
    private HomeListAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {

        this.homePresenter = new HomePresenter(this);
        this.homeDatas = new ArrayList<>();
        adapter = new HomeListAdapter(this,homeDatas);
        LinearLayoutManager manager =  new LinearLayoutManager(this);
        mHomeList.setLayoutManager(manager);
        mHomeList.setPullRefreshEnabled(true);
        mHomeList.setLoadingMoreEnabled(true);
        mHomeList.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新的监听
                homePresenter.refersh();
            }

            @Override
            public void onLoadMore() {

                //加载更多的监听
            }
        });
        mHomeList.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

        homePresenter.chinaLive();

    }

    @Override
    public void showProgressBar() {


        progressDialog = new ProgressDialog(this);
        progressDialog.show();
    }

    @Override
    public void dimiss() {

        if(progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void refersh(List<ChinaLive.TablistBean> homeData) {
        this.homeDatas.clear();
        this.homeDatas.addAll(homeData);
        adapter.notifyDataSetChanged();
        mHomeList.setRefreshComplete();
    }

    @Override
    public void loadMore(List<ChinaLive.TablistBean> homeData) {

        this.homeDatas.addAll(homeData);
        adapter.notifyDataSetChanged();

        mHomeList.setRefreshComplete();
    }

    @Override
    public void toHomeDetail() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

    }
}
