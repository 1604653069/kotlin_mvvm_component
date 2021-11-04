package com.hong.mine.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.mine.mvvm.MineViewModel
import com.hong.mine.repository.MineRepository

class MineViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MineViewModel(MineRepository()) as T
}