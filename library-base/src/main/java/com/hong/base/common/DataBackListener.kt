package com.hong.base.common

interface DataBackListener<T> {

    fun onSuccess(t:T)
    fun onFail(message:String)
}