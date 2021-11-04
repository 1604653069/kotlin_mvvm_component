package com.hong.library.api

import com.hong.library.api.beans.BaseResponse
import com.hong.library.api.beans.IndexBanner
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    /**
     * 玩android 首页banner
     */
    @GET("banner/json")
    fun getTestData():Observable<BaseResponse<List<IndexBanner>>>
}