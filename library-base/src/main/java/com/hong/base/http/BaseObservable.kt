package com.hong.base.http

import android.util.Log
import com.hong.base.utils.RxJavaGcManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class BaseObservable<T>: Observer<T> {

    override fun onSubscribe(d: Disposable) {
        Log.d("TAG","onSubscribe()")
        RxJavaGcManager.addDisposable(d)
    }

    override fun onNext(t: T) {
        Log.d("TAG","onNext()")
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFail("数据出错了->${e.toString()}")
    }

    override fun onComplete() {
       Log.d("TAG","onComplete()")
    }

    /**
     * 请求成功
     */
    abstract fun onSuccess(t:T)

    /**
     * 请求失败
     */
    abstract fun onFail(message:String)
}