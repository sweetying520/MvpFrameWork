package com.dream.mvpframework.presenter;

import android.util.Log;

import com.dream.mvpframework.base.presenter.BasePresenter;
import com.dream.mvpframework.contract.TestContract;
import com.dream.mvpframework.model.DataManager;

import javax.inject.Inject;

/**
 * @author Administrator
 * @date 2018/6/9
 */

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presneter {

    @Inject
    TestPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(TestContract.View view) {
        super.attachView(view);
        mView.testPresenter();
    }

    @Override
    public void testView() {
        Log.d("print", "Presenter层的引用");
    }
}
