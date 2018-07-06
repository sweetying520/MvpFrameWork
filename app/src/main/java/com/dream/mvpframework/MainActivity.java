package com.dream.mvpframework;

import android.view.View;

import com.dream.mvpframework.base.activity.AbstractSimpleActivity;
import com.dream.mvpframework.ui.Test2Activity;
import com.dream.mvpframework.ui.TestActivity;

import butterknife.OnClick;

/**
 * @author Administrator
 */
public class MainActivity extends AbstractSimpleActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    protected void initEventAndData() {
        setToolbarCenterTitle("MainActivity");
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    @OnClick({R.id.btn_testactivity, R.id.btn_test2activity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_testactivity:
                TestActivity.start(mActivity);
                break;
            case R.id.btn_test2activity:
                Test2Activity.start(mActivity);
                break;
            default:
                break;
        }
    }
}
