package com.dream.mvpframework.di.component;

import android.app.Activity;

import com.dream.mvpframework.MainActivity;
import com.dream.mvpframework.di.module.ActivityModule;
import com.dream.mvpframework.di.scope.ActivityScope;
import com.dream.mvpframework.ui.TestActivity;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();

    /**
     * 注入MAinActivity所需的依赖
     *
     * @param mainActivity MainActivity
     */
    void inject(MainActivity mainActivity);


    /**
     * 注入TestActivity所需的依赖
     *
     * @param testActivity testActivity
     */
    void inject(TestActivity testActivity);



}
