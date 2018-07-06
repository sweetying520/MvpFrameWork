package com.dream.mvpframework.base.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.dream.mvpframework.R;
import com.dream.mvpframework.util.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Common simple Activity
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class AbstractSimpleActivity extends SupportActivity {

    protected TextView tvTitle;
    private Unbinder unBinder;
    protected AbstractSimpleActivity mActivity;
    private View rootView;

    private static final int NORMAL_STATE = 0;
    private static final int LOADING_STATE = 1;
    public static final int ERROR_STATE = 2;

    private LottieAnimationView mLoadingAnimation;
    private View mLoadingView;
    private ViewGroup mNormalView;

    private int currentState = NORMAL_STATE;
    private View mErrorView;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = View.inflate(this,R.layout.activity_simple_abstract,null);
//        super.setContentView(R.layout.activity_simple_abstract);
        addContent();
        setContentView(rootView);
        mActivity = this;
        onViewCreated();
        ActivityCollector.getInstance().addActivity(this);
        initEventAndData();
    }

    private void addContent() {
        initToolbar();

        FrameLayout flContent = rootView.findViewById(R.id.fl_content);
        if (flContent == null) {
            return;
        }

        View.inflate(this, R.layout.loading_view, flContent);
        View.inflate(this, R.layout.error_view, flContent);
        View.inflate(this, getLayoutId(), flContent);

        mNormalView = flContent.findViewById(R.id.normal_view);
        mLoadingView = flContent.findViewById(R.id.loading_group);
        mErrorView = flContent.findViewById(R.id.error_group);
        TextView reloadTv = mErrorView.findViewById(R.id.error_reload_tv);
        reloadTv.setOnClickListener(v -> reload());
        mLoadingAnimation = mLoadingView.findViewById(R.id.loading_animation);
        mErrorView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mNormalView.setVisibility(View.VISIBLE);
        unBinder = ButterKnife.bind(this,rootView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        unBinder.unbind();
    }


    protected void initToolbar() {
        mToolbar = rootView.findViewById(R.id.toolbar);
        if(isHideToolbar()){
            mToolbar.setVisibility(View.GONE);
            return;
        }
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(v -> finish());
        tvTitle = mToolbar.findViewById(R.id.tv_toolbar_title);

    }

    /**
     * 设置toolbar中间的标题
     */
    protected void setToolbarCenterTitle(String title) {
        if (!TextUtils.isEmpty(title) && tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    /**
     * 是否显示Base的Toolbar 如果不显示则在上层用一个假的Toolbar代替
     * @return boolean
     */
    protected boolean isHideToolbar() {
        return false;
    }



    protected void reload() {
    }



    protected void onViewCreated() {

    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();



    public void showLoadingView() {
        if (currentState == LOADING_STATE) {
            return;
        }
        hideCurrentView();
        currentState = LOADING_STATE;
        mLoadingView.setVisibility(View.VISIBLE);
        mLoadingAnimation.setAnimation("loading_bus.json");
        mLoadingAnimation.loop(true);
        mLoadingAnimation.playAnimation();
    }


    public void showErrorView() {
        if (currentState == ERROR_STATE) {
            return;
        }
        hideCurrentView();
        currentState = ERROR_STATE;
        mErrorView.setVisibility(View.VISIBLE);
    }


    public void showNormalView() {
        if (currentState == NORMAL_STATE) {
            return;
        }
        hideCurrentView();
        currentState = NORMAL_STATE;
        mNormalView.setVisibility(View.VISIBLE);
    }

    private void hideCurrentView() {
        switch (currentState) {
            case NORMAL_STATE:
                mNormalView.setVisibility(View.GONE);
                break;
            case LOADING_STATE:
                mLoadingAnimation.cancelAnimation();
                mLoadingView.setVisibility(View.GONE);
                break;
            case ERROR_STATE:
                mErrorView.setVisibility(View.GONE);
            default:
                break;
        }
    }

}
