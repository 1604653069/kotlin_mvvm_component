package com.hong.project.mvvm

import androidx.lifecycle.ViewModelProvider
import com.hong.base.mvvm.BaseViewModel
import com.hong.project.repository.ProjectRepository

class ProjectViewModel(model: ProjectRepository) : BaseViewModel<Any, ProjectRepository>(model) {
}