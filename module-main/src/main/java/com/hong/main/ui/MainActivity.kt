package com.hong.main.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hong.base.BaseMvvmActivity
import com.hong.base.RouterPath
import com.hong.main.R
import com.hong.main.factory.MainViewModelFactory
import com.hong.main.mvvm.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterPath.MAIN_PAGE)
class MainActivity : BaseMvvmActivity<MainViewModel>() {
    private val fragments = mutableListOf<Fragment>()
    private lateinit var currentFragment:Fragment
    override fun logic() {
        initFragments()
        initListener()
        setStatusBarTextMode(this,true)
    }

    private fun initListener() {
        tab_bottom.setOnNavigationItemSelectedListener {
            var targetFragment: Fragment? =null
            when (it.itemId) {
                R.id.tab_main ->
                    targetFragment = fragments[0]
                R.id.tab_project ->
                    targetFragment = fragments[1]
                R.id.tab_square ->
                    targetFragment = fragments[2]
                R.id.tab_wechat ->
                    targetFragment = fragments[3]
                R.id.tab_mine ->
                    targetFragment = fragments[4]
            }
            switchFragment(targetFragment!!)
            true
        }
    }

    private fun initFragments() {
        //首页
        val homeFragment = ARouter.getInstance().build(RouterPath.HOME_PAGE).navigation() as Fragment
        //项目
        val projectFragment = ARouter.getInstance().build(RouterPath.PROJECT_PAGE).navigation() as Fragment
        // 广场
        val squareFragment = ARouter.getInstance().build(RouterPath.SQUARE_PAGE).navigation() as Fragment
        //公众号
        val officialFragment = ARouter.getInstance().build(RouterPath.OFFICIAL_PAGE).navigation() as Fragment
        //我的
        val mineFragment = ARouter.getInstance().build(RouterPath.MINE_PAGE).navigation() as Fragment

        fragments.add(homeFragment)
        fragments.add(projectFragment)
        fragments.add(squareFragment)
        fragments.add(officialFragment)
        fragments.add(mineFragment)

        if (homeFragment!=null) {
            val transaction =supportFragmentManager.beginTransaction()
            transaction.add(R.id.fl_content,homeFragment)
            currentFragment =homeFragment
            transaction.commitAllowingStateLoss()
        }
    }

    /**
     * fragment切换
     */
    private fun switchFragment(targetFragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        if (!targetFragment.isAdded) {
            transaction
                .hide(currentFragment)
                .add(R.id.fl_content,targetFragment)
                .commitAllowingStateLoss()
        } else {
            transaction
                .hide(currentFragment)
                .show(targetFragment)
                .commitAllowingStateLoss()
        }
        currentFragment = targetFragment
    }

    override fun createViewModel(): MainViewModel  = ViewModelProvider(this,MainViewModelFactory()).get(MainViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.activity_main

}