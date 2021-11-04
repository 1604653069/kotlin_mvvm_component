package com.hong.home.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.home.mvvm.HomeViewModel
import com.hong.home.repository.HomeRepository

class HomeViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HomeViewModel(HomeRepository()) as T
}