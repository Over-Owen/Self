package com.overz.viewmodel_test.b_viewmodel

import androidx.lifecycle.*
import com.overz.viewmodel_test.d_model.User

class MainViewModel(countReserved: Int) : ViewModel() {
    //将User数据使用LiveData包装成 LiveData对象
    private val userLiveData = MutableLiveData<User>()
    val userName: LiveData<String> = Transformations.map(userLiveData) {user ->
        "${user.firstName} ${user.lastName}"
    }

}