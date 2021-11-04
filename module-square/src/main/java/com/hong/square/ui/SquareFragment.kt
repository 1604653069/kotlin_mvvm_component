package com.hong.square.ui

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.hong.base.BaseMvvmFragment
import com.hong.base.RouterPath
import com.hong.square.R
import com.hong.square.factory.SquareViewModelFactory
import com.hong.square.mvvm.SquareViewModel

@Route(path = RouterPath.SQUARE_PAGE)
class SquareFragment :BaseMvvmFragment<SquareViewModel>() {
    override fun logic() {

    }

    override fun createViewModel(): SquareViewModel = ViewModelProvider(this,SquareViewModelFactory()).get(SquareViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.fragment_square

}