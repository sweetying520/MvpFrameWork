package com.dream.mvpframework.model.http.api;


import com.dream.mvpframework.model.data.BannerData;
import com.dream.mvpframework.model.data.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author quchao
 * @date 2018/2/12
 */

public interface Api {


    String BASR_URL = "http://test.bigbuy.win/";


    @GET("appapi/index/banner/id/1?cmd=home_slider_top&limit=5")
    Observable<BaseResponse<List<BannerData>>> getBanner();

}
