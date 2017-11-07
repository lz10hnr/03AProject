package com.jiyun.mvc_03a.adpater;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by xingge on 2017/10/23.
 */

public class HomeBannerAdapter extends PagerAdapter {

    private List<ImageView> imgs;
    public HomeBannerAdapter(List<ImageView> imgs){
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(imgs.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imgs.get(position);
        container.addView(imageView);
        return imageView;
    }
}
