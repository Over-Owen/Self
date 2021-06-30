package com.overz.roomoperatedatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * 数据访问 - 接口
 * </p>
 * Dao类中农包含（接口里面包含增删改查方法）,定义了所有数据库操作的方法，
 * 接口定义标明注解@Dao；插入数据标明@Insert注解；修改数据标明@update；删除数据标明@Delete注解；查询标明@Query注解；
 * </p>
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}