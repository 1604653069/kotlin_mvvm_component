package com.hong.library.api

import com.hong.library.api.beans.BaseResponse
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import java.lang.RuntimeException

class Transform {
    companion object{
        fun <T> transformer(): ObservableTransformer<BaseResponse<T>, T> {
            return ObservableTransformer<BaseResponse<T>,T> { it ->
                return@ObservableTransformer it.flatMap {
                    if(it.errorCode==0&&it.data!=null)
                        return@flatMap Observable.just(it.data)
                    else
                        return@flatMap Observable.error(RuntimeException(it.errorMsg))
                }
            }
        }
    }
}