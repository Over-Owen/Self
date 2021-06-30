package com.overz.room.data

import androidx.room.*

@Dao
interface UserDao {


    //通过用户id查询用户信息
    @Query("SELECT *FROM user_info_table WHERE user_id = :id")
    fun getUserById(id: Int): User

    //插入数据
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    //删除数据
    @Delete
    fun deleteUser(user: User)

    @Update
    fun updateUserData(user: User)
}