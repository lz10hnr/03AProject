package com.jiyun.mvp_03a.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.jiyun.mvp_03a.R;
import com.jiyun.mvp_03a.model.entity.ChinaLive;

import java.util.List;

/**
 * Created by xingge on 2017/10/25.
 */

public class HomeListAdapter extends BaseAdapter<ChinaLive.TablistBean> {

    public HomeListAdapter(Context context, List<ChinaLive.TablistBean> datas) {
        super(context, R.layout.home_listview_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, ChinaLive.TablistBean tablistBean) {
        holder.setText(R.id.itemTitle,tablistBean.getTitle());
    }
}
