package com.dream.mvpframework.di.module;


import com.dream.mvpframework.common.MyApplication;
import com.dream.mvpframework.model.DataManager;
import com.dream.mvpframework.model.db.DbHelper;
import com.dream.mvpframework.model.db.GreenDaoHelper;
import com.dream.mvpframework.model.http.HttpHelper;
import com.dream.mvpframework.model.http.RetrofitHelper;
import com.dream.mvpframework.model.prefs.PreferenceHelper;
import com.dream.mvpframework.model.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(GreenDaoHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }

}
