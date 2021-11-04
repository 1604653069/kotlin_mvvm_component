package com.hong.home.ui
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.hong.base.BaseMvvmFragment
import com.hong.base.RouterPath
import com.hong.home.factory.HomeViewModelFactory
import com.hong.home.R
import com.hong.home.mvvm.HomeViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.concurrent.TimeUnit

@Route(path = RouterPath.HOME_PAGE)
class HomeFragment: BaseMvvmFragment<HomeViewModel>() {

    override fun logic() {
        initData()
        observable()
    }

    @SuppressLint("CheckResult")
    private fun initData() {
        //发送测试请求数据
        viewModel.getTestData()
    }

    private fun observable(){
        //成功
        viewModel.getDataLiveData().observe(this){
            Log.d("TAG","请求成功->${it}")
        }
        //失败
        viewModel.getErrorLiveData().observe(this){
            Log.d("TAG","请求失败${it}")
        }
    }

    override fun createViewModel(): HomeViewModel = ViewModelProvider(this, HomeViewModelFactory()).get(HomeViewModel::class.java)


    override fun getLayoutId(): Int  = R.layout.fragment_home


}