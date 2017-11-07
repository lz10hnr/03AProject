package com.jiyun.mvc_03a.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.mvc_03a.R;
import com.jiyun.mvc_03a.model.enity.HomeData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xingge on 2017/10/20.
 */

public class HomeAdapter extends BaseAdapter {

    private List<HomeData.ResultBean.ListBean> datas;
    private LayoutInflater inflater;

    public HomeAdapter(Context context, List<HomeData.ResultBean.ListBean> datas) {
        this.inflater = LayoutInflater.from(context);
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home_list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        holder.homeItemTitle.setText(datas.get(position).getTitle());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.homeItemImg)
        ImageView homeItemImg;
        @BindView(R.id.homeItemTitle)
        TextView homeItemTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
