package com.hong.base.mvvm

import android.util.Log
import androidx.lifecycle.*
import com.hong.base.repository.BaseRepository
import com.hong.base.utils.RxJavaGcManager

open class BaseViewModel<T,M:BaseRepository>(model:M) :ViewModel(),LifecycleObserver {

    val repository = model

    protected val dataLiveData: MutableLiveData<T> = MutableLiveData()

    protected val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun getDataLiveData():LiveData<T>{
        return dataLiveData
    }

    fun getErrorLiveData():LiveData<String>{
        return errorLiveData
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d("TAG","onStop()")
        RxJavaGcManager.clearAllDisposable()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
    }
}