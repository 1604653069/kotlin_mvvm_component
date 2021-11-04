package com.hong.base.http

import com.hong.base.gson.CustomGsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.wanandroid.com/")
            .addConverterFactory(CustomGsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())
            .build()
    }

    private fun <T> getApiService(service:Class<T>):T{
        return getRetrofit().create(service)
    }

    private fun getOkHttpClient():OkHttpClient{
        val builder = OkHttpClient.Builder()
        builder.writeTimeout(15, TimeUnit.SECONDS)
        builder.readTimeout(15, TimeUnit.SECONDS)
        builder.connectTimeout(15, TimeUnit.SECONDS)
        builder.addInterceptor(LoggingInterceptor())
        return builder.build()
    }
}