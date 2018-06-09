package com.dream.mvpframework.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.dream.mvpframework.di.component.AppComponent;
import com.dream.mvpframework.di.component.DaggerAppComponent;
import com.dream.mvpframework.di.module.AppModule;
import com.dream.mvpframework.di.module.HttpModule;
import com.dream.mvpframework.util.CommonUtils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;

/**
 *
 * @author Administrator
 * @date 2018/6/9
 */

public class MyApplication extends Application{

    private static MyApplication mApp;
    private RefWatcher mRefWatcher;
    private static volatile AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        //检测内存泄漏
        initLeakcanary();

        //tencent bugly
        initTencentBugly();
    }

    private void initTencentBugly() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
        String processName = CommonUtils.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(getApplicationContext(), MyConstants.BUGLY_ID, false, strategy);
    }

    private void initLeakcanary() {
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        mRefWatcher = LeakCanary.install(this);
    }


    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }

    public static MyApplication getInstance(){
        return mApp;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mApp))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
