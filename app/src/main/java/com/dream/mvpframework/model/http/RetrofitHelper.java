package com.dream.mvpframework.model.http;

import com.dream.mvpframework.model.data.BannerData;
import com.dream.mvpframework.model.data.BaseResponse;
import com.dream.mvpframework.model.http.api.Api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


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


    @Override
    public Observable<BaseResponse<List<BannerData>>> getBanner() {
        return mApi.getBanner();
    }
}
