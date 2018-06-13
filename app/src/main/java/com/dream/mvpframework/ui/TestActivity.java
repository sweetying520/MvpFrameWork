package com.dream.mvpframework.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.dream.mvpframework.R;
import com.dream.mvpframework.base.activity.BaseActivity;
import com.dream.mvpframework.contract.TestContract;
import com.dream.mvpframework.presenter.TestPresenter;

/**
 *
 * @author Administrator
 * @date 2018/6/9
 */

public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View{

    private Context mContext;

    @Override
    public void testPresenter() {
        Log.d("print", "--->持有View层的引用");
    }

    @Override
    public void showSuccess() {
        Toast.makeText(mContext, "获取数据成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initEventAndData() {
        mContext = this;
        mPresenter.testView();
        mPresenter.testGetData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public static void start(Context mContext){
        mContext.startActivity(new Intent(mContext,TestActivity.class));
    }
}
