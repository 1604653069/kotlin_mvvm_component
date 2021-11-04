package com.hong.base

class SimpleData<out T>(private val data:T?) {
    fun get():T?{
        return data
    }
}