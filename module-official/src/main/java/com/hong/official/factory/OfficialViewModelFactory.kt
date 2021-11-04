package com.hong.official.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.official.mvvm.OfficialViewModel
import com.hong.official.repository.OfficialRepository

class OfficialViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  = OfficialViewModel(OfficialRepository()) as T
}