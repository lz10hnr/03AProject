package com.jiyun.oschina.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.jiyun.oschina.R;
import com.jiyun.oschina.model.entity.Home;

import java.util.List;

/**
 * Created by xingge on 2017/11/1.
 */

public class HomeNewsItemAdapter extends BaseAdapter<Home.NewsBean>{

    public HomeNewsItemAdapter(Context context, List<Home.NewsBean> datas) {
        super(context, R.layout.home_list_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Home.NewsBean newsBean) {
        holder.setText(R.id.itemTitle,newsBean.getTitle());
    }
}
