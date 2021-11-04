package com.hong.project.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.project.mvvm.ProjectViewModel
import com.hong.project.repository.ProjectRepository

class ProjectViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ProjectViewModel(ProjectRepository()) as T
}