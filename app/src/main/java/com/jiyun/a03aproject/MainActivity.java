package com.jiyun.a03aproject;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.contentGroup)
    FrameLayout contentGroup;
    @BindView(R.id.homeBtn)
    Button homeBtn;
    @BindView(R.id.videoBtn)
    Button videoBtn;
    @BindView(R.id.mineBtn)
    Button mineBtn;
    @BindView(R.id.notifyAllBtn)
    Button notifyAllBtn;

    private HomeFragment homeFragment;
    private VideoFragment videoFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();

        notifyAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObservalbeManager.getInstance().notifyMessage("哥们儿更新内容了");
            }
        });
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        videoFragment = new VideoFragment();
        mineFragment = new MineFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contentGroup, homeFragment);
        transaction.add(R.id.contentGroup, videoFragment);
        transaction.add(R.id.contentGroup, mineFragment);
        transaction.hide(videoFragment);
        transaction.hide(mineFragment);
        transaction.show(homeFragment);
        transaction.commit();
    }

    @OnClick({R.id.homeBtn, R.id.videoBtn, R.id.mineBtn})
    public void onViewClicked(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.homeBtn:
                transaction.hide(videoFragment);
                transaction.hide(mineFragment);
                transaction.show(homeFragment);
                break;
            case R.id.videoBtn:
                transaction.hide(homeFragment);
                transaction.hide(mineFragment);
                transaction.show(videoFragment);
                break;
            case R.id.mineBtn:
                transaction.hide(homeFragment);
                transaction.hide(videoFragment);
                transaction.show(mineFragment);
                break;
        }
        transaction.commit();
    }

}
