package com.hong.main.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.main.mvvm.MainViewModel
import com.hong.main.repository.MainRepository

class MainViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(MainRepository()) as T
}