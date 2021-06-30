package com.overz.viewmodel_test.b_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(countReserved: Int) : ViewModel() {
    var counter = countReserved
}
class MainViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(countReserved) as T
    }
}