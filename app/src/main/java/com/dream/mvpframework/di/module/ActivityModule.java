package com.dream.mvpframework.di.module;

import android.app.Activity;

import com.dream.mvpframework.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return mActivity;
    }

}
