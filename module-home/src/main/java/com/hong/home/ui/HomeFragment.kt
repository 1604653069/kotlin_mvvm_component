package com.hong.home.ui
import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hong.base.BaseMvvmFragment
import com.hong.base.RouterPath
import com.hong.home.R
import com.hong.home.factory.HomeViewModelFactory
import com.hong.home.mvvm.HomeViewModel
import com.hong.library.api.beans.IndexBanner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_home.*

@Route(path = RouterPath.HOME_PAGE)
class HomeFragment: BaseMvvmFragment<HomeViewModel>() {

    /**
     * 业务逻辑
     */
    override fun logic() {
        initData()
        observable()
    }

    @SuppressLint("CheckResult")
    private fun initData() {
        //发送头部banner请求
        viewModel.getTestData()
    }

    /**
     * 数据监听
     */
    private fun observable(){
        //监听banner的数据
        viewModel.getDataLiveData().observe(this){
            Log.d("TAG","请求成功->${it}")
           showBanner(it)
        }

        //错误数据请求
        viewModel.getErrorLiveData().observe(this){
            Log.d("TAG","请求失败${it}")
        }
    }

    /**
     * 头部banner
     */
    private fun showBanner(it: List<IndexBanner>?) {
        banner.addBannerLifecycleObserver(this)
            .setAdapter(object :BannerImageAdapter<IndexBanner>(it){
                override fun onBindView(holder: BannerImageHolder?, data: IndexBanner?, position: Int, size: Int) {
                    Glide.with(holder!!.itemView).load(data!!.imagePath).apply(RequestOptions.bitmapTransform(RoundedCorners(30))).into(holder!!.imageView)
                }
            }).indicator = CircleIndicator(context)
    }

    override fun createViewModel(): HomeViewModel = ViewModelProvider(this, HomeViewModelFactory()).get(HomeViewModel::class.java)

    override fun getLayoutId(): Int  = R.layout.fragment_home

    override fun initView() {

    }
}