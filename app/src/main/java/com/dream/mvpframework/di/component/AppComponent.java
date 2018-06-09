package com.dream.mvpframework.di.component;


import com.dream.mvpframework.common.MyApplication;
import com.dream.mvpframework.di.module.AppModule;
import com.dream.mvpframework.di.module.HttpModule;
import com.dream.mvpframework.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    MyApplication getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
