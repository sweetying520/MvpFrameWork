package com.dream.mvpframework.model.http;

import com.dream.mvpframework.model.http.api.Api;

import javax.inject.Inject;


/**
 * @author quchao
 * @date 2017/11/27
 */

public class RetrofitHelper implements HttpHelper {

    private Api mApi;

    @Inject
    RetrofitHelper(Api api) {
        mApi = api;
    }



}
