package com.dream.mvpframework.model.http;


import com.dream.mvpframework.model.data.BannerData;
import com.dream.mvpframework.model.data.BaseResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author quchao
 * @date 2017/11/27
 */

public interface HttpHelper {

    Observable<BaseResponse<List<BannerData>>> getBanner();
}
