package com.hong.base.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class LoggingInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //发送时截取数据

        //发送时截取数据
        val request = chain.request()
        val t1 = System.nanoTime() //请求发起的时间

        Log.e("TAG", String.format("发送请求:%s", request.url()))
        //接收时截取数据
        //接收时截取数据
        val response = chain.proceed(request)
        val t2 = System.nanoTime() //收到响应的时间

        val responseBody = response.peekBody((1024 * 1024).toLong())
        val httpMsg = String.format(
            Locale.CHINA, "接收响应:%s%n请求时间:%.1fms%n报文信息:%s返回JSON:%s",
            response.request().url(),
            (t2 - t1) / 1e6,
            response.headers(),
            responseBody.string()
        )
        Log.d("TAG", httpMsg)
        return response
    }
}