package com.overz.data_binding_test.data_binding

import androidx.databinding.BaseObservable

data class Account(
    var name: String,
    var level:Int
): BaseObservable()