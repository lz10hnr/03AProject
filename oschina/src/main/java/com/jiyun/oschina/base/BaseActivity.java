package com.jiyun.oschina.base;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.oschina.R;
import com.jiyun.oschina.app.App;
import com.jiyun.oschina.module.home.fragment.HomeFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by xingge on 2017/10/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public BaseFragment lastFragment;
    //获取Fragment管理器
    private FragmentManager manager;
    //key是Fragment类名 value是Fragment对应的容器的ID
    public Map<String,Integer> fragments = new HashMap<>();
    //key是容器ID，value是上一个Fragment
    public Map<Integer,BaseFragment> lastFragments = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.context = this;
        this.manager  = getSupportFragmentManager();
        ButterKnife.bind(this);
        init();
        loadData();

    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void loadData();


    /**
     * 该方法用于Fragment切换
     * @param containerId 容器ID
     * @param fragmentClass 要切换的Fragment 目标Fragment
     * @param bundle 跳转Fragment是要传递的参数
     * @param isReplace 是否替换当前Fragment true：replace替换 false :hind 隐藏
     * @param isBack 该Fragment是否要添加至回退栈
     */
    public void changFragment(int containerId, Class<? extends BaseFragment> fragmentClass, Bundle bundle, boolean isReplace, boolean isBack){

        //获取Fragment类名 下面会用到类名做Tag
        String fragmentName = fragmentClass.getSimpleName();
        //开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        //通过Tag来查找Fragment  如果查找到返回的就是该Fragment对象 否则是null 代表该Fragment没有被创建过
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
        //如果Fragment为null 就通过Java动态代理创建对应的Fragment对象
        if(currentFragment == null){
            try {
                //通过Java动态代理创建Fragment
                currentFragment = fragmentClass.newInstance();
                transaction.add(containerId,currentFragment,fragmentName);
                fragments.put(fragmentName,containerId);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //isReplace 为true代表替换
        if(isReplace) {
            if(lastFragments.size() > 0){
                //取出上一个Fragment
                lastFragment = lastFragments.get(containerId);
                //如果上一个Fragment不等于null就隐藏
                if(lastFragment != null){
                    List<android.support.v4.app.Fragment> fragments = manager.getFragments();
                    //从FragmentManager中把替换掉的Fragment移除
                    fragments.remove(lastFragment);
                }
            }
            transaction.replace(containerId, currentFragment, fragmentName);
        } else {
            if(lastFragments.size() > 0){
                //取出上一个Fragment
                lastFragment = lastFragments.get(containerId);
                if (lastFragment != null)
                    transaction.hide(lastFragment);

            }

            //显示当前的Fragment
            transaction.show(currentFragment);

        }
        //bundle 不等于null代表要传递参数
        if(bundle != null) {
            currentFragment.setParams(bundle);

        }
        //isBack为true是添加至回退栈
        if (isBack){
            transaction.addToBackStack(fragmentName);
        }

        transaction.commit();
        //记录当前容器上一个Fragment
        lastFragments.put(containerId,currentFragment);
    }

}
