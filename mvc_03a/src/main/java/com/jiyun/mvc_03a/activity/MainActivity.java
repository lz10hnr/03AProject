package com.jiyun.mvc_03a.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiyun.mvc_03a.R;
import com.jiyun.mvc_03a.adpater.HomeAdapter;
import com.jiyun.mvc_03a.adpater.HomeBannerAdapter;
import com.jiyun.mvc_03a.base.BaseActivity;
import com.jiyun.mvc_03a.model.HttpFactory;
import com.jiyun.mvc_03a.model.biz.HomeModel;
import com.jiyun.mvc_03a.model.biz.IHomeModel;
import com.jiyun.mvc_03a.model.enity.HomeBanner;
import com.jiyun.mvc_03a.model.enity.HomeData;
import com.jiyun.mvc_03a.model.net.callback.INetworkCallback;
import com.jiyun.mvc_03a.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mListView)
    ListView mListView;
    private List<HomeData.ResultBean.ListBean> datas;
    private List<ImageView> banners;
    private HomeAdapter adapter;
    private HomeBannerAdapter bannerAdapter;
    private IHomeModel homeModel;
    LinearLayout pointGroupLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        loadBanner();
        homeModel = new HomeModel();
        datas = new ArrayList<>();
        adapter = new HomeAdapter(this,datas);

        mListView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        homeModel.loadHomeList("a332c6b34264527ac142764eaed9364d", 1, new INetworkCallback<HomeData>() {
            @Override
            public void onSuccess(HomeData homeData) {
                datas.addAll(homeData.getResult().getList());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
        homeModel.loadHomeBanner(new INetworkCallback<HomeBanner>() {
            @Override
            public void onSuccess(HomeBanner homeBanner) {


                final List<HomeBanner.PagelistBean> pagelist = homeBanner.getPagelist();


                        for (HomeBanner.PagelistBean bigImgBean : pagelist){
                            String imageUrl = bigImgBean.getImage();
                            ImageView imageView = new ImageView(MainActivity.this);
                            //通过LayoutParams设置ImageView的宽度和高度
                            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                    Utils.dip2px(MainActivity.this,200));
                            imageView.setLayoutParams(params);
                            //让图片充满imagview
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            HttpFactory.create().loadImage(imageUrl,imageView);
                            banners.add(imageView);

                            TextView textView = new TextView(MainActivity.this);
                            LinearLayout.LayoutParams pointParams = new LinearLayout.LayoutParams(Utils.dip2px(MainActivity.this,5),
                                    Utils.dip2px(MainActivity.this,5));
                            pointParams.leftMargin = Utils.dip2px(MainActivity.this,10);
                            textView.setLayoutParams(pointParams);
                            textView.setBackgroundColor(Color.parseColor("#ff0000"));
                            pointGroupLayout.addView(textView);

                        }
                        bannerAdapter.notifyDataSetChanged();
                    }



            @Override
            public void onError(String errorMsg) {

            }
        });
    }


    private void loadBanner(){
        //通过布局加载器加载头布局到ListView中
        View view = LayoutInflater.from(this).inflate(R.layout.home_banner, null);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.homeBanner);

        pointGroupLayout = (LinearLayout) view.findViewById(R.id.pointGroup);
        banners = new ArrayList<>();
        bannerAdapter = new HomeBannerAdapter(banners);
        viewPager.setAdapter(bannerAdapter);
        mListView.addHeaderView(view);
    }


}
