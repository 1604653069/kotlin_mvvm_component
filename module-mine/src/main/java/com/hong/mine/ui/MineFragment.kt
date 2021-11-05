package com.hong.mine.ui

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.hong.base.BaseMvvmFragment
import com.hong.base.RouterPath
import com.hong.mine.R
import com.hong.mine.factory.MineViewModelFactory
import com.hong.mine.mvvm.MineViewModel

@Route(path = RouterPath.MINE_PAGE)
class MineFragment :BaseMvvmFragment<MineViewModel>() {
    override fun logic() {

    }

    override fun createViewModel(): MineViewModel = ViewModelProvider(this,MineViewModelFactory()).get(MineViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.fragment_mine
    override fun initView() {

    }
}