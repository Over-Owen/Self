package com.overz.viewmodel_test.c_repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.overz.viewmodel_test.d_model.User

object Repository {

    fun getUser(userId:String):LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId,0)
        return liveData
    }
}