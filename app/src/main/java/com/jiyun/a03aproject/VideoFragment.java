package com.jiyun.a03aproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/10/19.
 */

public class VideoFragment extends Fragment implements Observer{
    @BindView(R.id.resultMessage)
    TextView resultMessage;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        ObservalbeManager.getInstance().attach(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void update(String content) {
        resultMessage.setText(content);
    }
}
