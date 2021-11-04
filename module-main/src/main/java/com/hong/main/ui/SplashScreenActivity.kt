package com.hong.main.ui

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.hong.base.BaseMvvmActivity
import com.hong.base.RouterPath
import com.hong.main.R
import com.hong.main.factory.MainViewModelFactory
import com.hong.main.mvvm.MainViewModel

class SplashScreenActivity: BaseMvvmActivity<MainViewModel>() {
    override fun logic() {
        ARouter.getInstance().build(RouterPath.MAIN_PAGE).navigation()
        finish()
    }

    override fun createViewModel(): MainViewModel = ViewModelProvider(this,MainViewModelFactory()).get(MainViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.activity_splash
}