package com.hong.base.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseRepository {

    fun <T> observeAt(observable: Observable<T>):Observable<T>{
        return observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> observeFg(observable: Observable<T>):Observable<T>{
        return observable.subscribeOn(Schedulers.io()) //请求在io线程中
            .unsubscribeOn(Schedulers.io()) //取消订阅在io线程中
            .observeOn(AndroidSchedulers.mainThread()) //指定在主线程中
    }
}