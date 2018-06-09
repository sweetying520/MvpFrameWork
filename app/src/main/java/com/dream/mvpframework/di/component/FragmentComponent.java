package com.dream.mvpframework.di.component;

import android.app.Activity;

import com.dream.mvpframework.di.module.FragmentModule;
import com.dream.mvpframework.di.scope.FragmentScope;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();



}
