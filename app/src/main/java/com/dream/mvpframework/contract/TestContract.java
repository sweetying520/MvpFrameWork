package com.dream.mvpframework.contract;

import com.dream.mvpframework.base.presenter.AbstractPresenter;
import com.dream.mvpframework.base.view.BaseView;

/**
 * Created by Administrator on 2018/6/9.
 */

public interface TestContract {

    interface View extends BaseView{
        void testPresenter();
    }

    interface Presneter extends AbstractPresenter<View>{
        void testView();
    }
}
