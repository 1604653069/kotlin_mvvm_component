package com.hong.official.ui

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.hong.base.BaseMvvmFragment
import com.hong.base.RouterPath
import com.hong.official.R
import com.hong.official.factory.OfficialViewModelFactory
import com.hong.official.mvvm.OfficialViewModel

@Route(path = RouterPath.OFFICIAL_PAGE)
class OfficialFragment :BaseMvvmFragment<OfficialViewModel>() {
    override fun logic() {

    }

    override fun createViewModel(): OfficialViewModel = ViewModelProvider(this,OfficialViewModelFactory()).get(OfficialViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.fragment_official

    override fun initView() {

    }
}