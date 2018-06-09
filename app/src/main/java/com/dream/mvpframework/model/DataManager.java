package com.dream.mvpframework.model;


import com.dream.mvpframework.model.db.DbHelper;
import com.dream.mvpframework.model.http.HttpHelper;
import com.dream.mvpframework.model.prefs.PreferenceHelper;

/**
 * @author quchao
 * @date 2017/11/27
 */

public class DataManager implements HttpHelper, DbHelper, PreferenceHelper {

    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferenceHelper = preferencesHelper;
    }

}
