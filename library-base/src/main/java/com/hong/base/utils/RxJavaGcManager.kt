package com.hong.base.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object RxJavaGcManager {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    fun deleteDisposable(disposable: Disposable){
        compositeDisposable.delete(disposable)
    }

    fun clearAllDisposable(){
        compositeDisposable.clear()
    }

    fun disposableActive(disposable: Disposable){
        synchronized(this){
            if (disposable!=null) {
                disposable.dispose()
                deleteDisposable(disposable)
            }
        }
    }
}