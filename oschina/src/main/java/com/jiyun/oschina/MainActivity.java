package com.jiyun.oschina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.jiyun.oschina.base.BaseActivity;
import com.jiyun.oschina.base.BaseFragment;
import com.jiyun.oschina.module.find.fragment.FindFragment;
import com.jiyun.oschina.module.home.fragment.HomeFragment;
import com.jiyun.oschina.module.mine.fragment.MineFragment;
import com.jiyun.oschina.module.tween.fragment.TweenFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homeBtn)
    RadioButton homeBtn;
    @BindView(R.id.tweenBtn)
    RadioButton tweenBtn;
    @BindView(R.id.publishBtn)
    RadioButton publishBtn;
    @BindView(R.id.findBtn)
    RadioButton findBtn;
    @BindView(R.id.mineBtn)
    RadioButton mineBtn;
    private long lastTime;//记录上一次点击back键的时间
//    private HomeFragment homeFragment;
//    private TweenFragment tweenFragment;
//    private FindFragment findFragment;
//    private MineFragment mineFragment;
//
//    private BaseFragment lastFragment;//记录上一个Fragment  为什么要记录？因为要把它隐藏掉

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        homeFragment = new HomeFragment();
//        transaction.add(R.id.container,homeFragment,"HomeFragment");
//        transaction.commit();
//        lastFragment = homeFragment;

        changFragment(R.id.container,HomeFragment.class,null,false,true);
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.homeBtn, R.id.tweenBtn, R.id.publishBtn, R.id.findBtn, R.id.mineBtn})
    public void onViewClicked(View view) {
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.homeBtn:
                changFragment(R.id.container,HomeFragment.class,null,false,true);
//                if(homeFragment == null) {
//                    homeFragment = new HomeFragment();
//                    transaction.add(R.id.container, homeFragment, "HomeFragment");
//                }else {
//                    transaction.show(homeFragment);
//                }
//                transaction.hide(lastFragment);
//                lastFragment = homeFragment;
                break;
            case R.id.tweenBtn:
                changFragment(R.id.container,TweenFragment.class,null,false,true);
//                if(tweenFragment == null) {
//                    tweenFragment = new TweenFragment();
//                    transaction.add(R.id.container,tweenFragment,"TweenFragment");
//                }else {
//                    transaction.show(tweenFragment);
//                }
//                transaction.hide(lastFragment);
//                lastFragment = tweenFragment;

                break;
            case R.id.publishBtn:
                break;
            case R.id.findBtn:
                changFragment(R.id.container,FindFragment.class,null,false,true);
//                if(findFragment == null) {
//                    findFragment = new FindFragment();
//                    transaction.add(R.id.container,findFragment,"FindFragment");
//                }else {
//                    transaction.show(findFragment);
//                }
//                transaction.hide(lastFragment);
//                lastFragment = findFragment;
                break;
            case R.id.mineBtn:
                changFragment(R.id.container,MineFragment.class,null,false,true);
//                if(mineFragment == null) {
//                    mineFragment = new MineFragment();
//                    transaction.add(R.id.container,mineFragment,"MineFragment");
//                }else {
//                    transaction.show(mineFragment);
//                }
//                transaction.hide(lastFragment);
//                lastFragment = mineFragment;

                break;
        }
//        transaction.commit();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        FragmentManager manager = getSupportFragmentManager();
        //获取栈顶Fragment的索引下标 manager.getBackStackEntryCount() - 1
        //根据下标获取栈顶的Fragment  manager.getBackStackEntryAt
        FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1);
        //获取栈顶的Fragment的名字
        String name = entry.getName();
        //一级页面直接退出应用
        if("HomeFragment".equals(name) || "MineFragment".equals(name)
                || "TweenFragment".equals(name) || "FindFragment".equals(name)){

            if(System.currentTimeMillis() - lastTime > 2000) {
                lastTime = System.currentTimeMillis();
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            }else {
                finish();
            }
        }else {
            //立即弹栈
            manager.popBackStackImmediate();
            //再次获取栈顶的Fragment
            FragmentManager.BackStackEntry entryAt = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1);
            //再次获取栈顶的Fragment的名字
            String fragmentName = entryAt.getName();
            Log.d("MainActivity", "------"+fragmentName+"-------");
            //根据栈顶的名字来查找对应的Fragment
            BaseFragment topFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
//            //重置lastFragment
//            BaseActivity.lastFragment = topFragment;
            int containerId = fragments.get(fragmentName);
            lastFragments.put(containerId,topFragment);

        }


    }




}
