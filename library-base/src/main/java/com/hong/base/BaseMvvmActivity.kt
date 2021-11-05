package com.hong.base

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.hong.base.mvvm.BaseViewModel
import com.hong.base.utils.OSUtil
import com.hong.base.view.FlyToast
import com.jaeger.library.StatusBarUtil

abstract class BaseMvvmActivity<VM : BaseViewModel<*, *>> :AppCompatActivity() {
    lateinit var viewModel:VM
    lateinit var flyToast: FlyToast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //加载布局
        setContentView(getLayoutId())
        //阿里注解注入
        ARouter.getInstance().inject(this) //注入
        //状态栏透明
        StatusBarUtil.setTransparent(this)
        //初始化viewModel
        viewModel = createViewModel()
        //感知activity的生命周期
        lifecycle.addObserver(viewModel)
        //业务逻辑
        logic()
    }

    /**
     * 业务逻辑代码
     */
    abstract fun logic()

    /**
     * 创建viewmodel
     */
    abstract fun createViewModel(): VM

    /**
     * 加载布局
     */
    abstract fun getLayoutId():Int

    fun T(message:String){
        if (flyToast==null) {
            flyToast = FlyToast(this,message,Toast.LENGTH_SHORT)
            flyToast.setMessage(message)
            flyToast.setGravity(Gravity.CENTER,0,0)
        } else {
            flyToast.setMessage(message)
        }
        flyToast.show()
    }

    /**
     * 状态栏字体
     */
    open fun setStatusBarTextMode(activity: Activity, isDark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            when {
                OSUtil.isMIUI() -> {
                    OSUtil.setMIUIStatusBarTextMode(activity,isDark)
                }
                OSUtil.isFlyme() -> {
                    OSUtil.setFlymeStatusBarTextMode(activity,isDark)
                }
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
                    val window = activity.window
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
        }
    }
}