package com.hong.home.mvvm

import android.annotation.SuppressLint
import com.hong.base.common.DataBackListener
import com.hong.base.mvvm.BaseViewModel
import com.hong.home.repository.HomeRepository
import com.hong.library.api.beans.IndexBanner

class HomeViewModel(model: HomeRepository) : BaseViewModel<List<IndexBanner>, HomeRepository>(model), DataBackListener<List<IndexBanner>> {

    @SuppressLint("CheckResult")
    fun getTestData(){
        repository.getTestData(this)

    }

    override fun onSuccess(t: List<IndexBanner>) {
        dataLiveData.value = t
    }

    override fun onFail(message: String) {
        errorLiveData.value = message
    }

}