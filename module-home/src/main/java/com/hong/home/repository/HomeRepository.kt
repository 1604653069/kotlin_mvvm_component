package com.hong.home.repository

import com.hong.base.common.DataBackListener
import com.hong.base.http.BaseObservable
import com.hong.base.http.RetrofitManager
import com.hong.base.repository.BaseRepository
import com.hong.library.api.Api
import com.hong.library.api.Transform
import com.hong.library.api.beans.IndexBanner


class HomeRepository:BaseRepository() {

    fun getTestData(dataBackListener: DataBackListener<List<IndexBanner>>){
        observeFg(RetrofitManager.getRetrofit().create(Api::class.java).getTestData())
            .compose(Transform.transformer())
            .subscribe(object : BaseObservable<List<IndexBanner>>() {
                override fun onSuccess(t: List<IndexBanner>) = dataBackListener.onSuccess(t)
                override fun onFail(message: String) = dataBackListener.onFail(message)
            })
    }

}