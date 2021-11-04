package com.hong.base

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.hong.base.mvvm.BaseViewModel
import com.hong.base.view.FlyToast

abstract class BaseMvvmFragment<VM:BaseViewModel<*,*>> :Fragment(){
    lateinit var viewModel: VM
    lateinit var flyToast: FlyToast
    lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(getLayoutId(),container,false)
        //注册阿里Arouter
        ARouter.getInstance().inject(this)
        viewModel = createViewModel()
        logic()
        //感知fragment的生命周期
        lifecycle.addObserver(viewModel)
        return mView
    }

    fun T(message:String){
        if (flyToast==null) {
            flyToast = FlyToast(context!!,message,Toast.LENGTH_SHORT)
            flyToast.setGravity(Gravity.CENTER,0,0)
            flyToast.setMessage(message)
        } else {
            flyToast.setMessage(message)
        }
        flyToast.show()
    }

    abstract fun logic()

    abstract fun createViewModel(): VM

    abstract fun getLayoutId():Int

}