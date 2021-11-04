package com.hong.square.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.square.mvvm.SquareViewModel
import com.hong.square.repository.SquareRepository

class SquareViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = SquareViewModel(SquareRepository()) as T
}