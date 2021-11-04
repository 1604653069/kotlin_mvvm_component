package com.hong.project.ui

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.hong.base.BaseMvvmFragment
import com.hong.base.RouterPath
import com.hong.project.R
import com.hong.project.factory.ProjectViewModelFactory
import com.hong.project.mvvm.ProjectViewModel

@Route(path = RouterPath.PROJECT_PAGE)
class ProjectFragment :BaseMvvmFragment<ProjectViewModel>() {

    override fun logic() {

    }

    override fun createViewModel(): ProjectViewModel = ViewModelProvider(this,ProjectViewModelFactory()).get(ProjectViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.fragment_project

}