package com.overz.nativedatasave.roomOperateDatabase

import androidx.room.*

interface UserDao {
    //查询user中所有数据
    @get:Query("SELECT * FROM user")
    val all: List<User?>?

    @Query("SELECT * FROM user WHERE 'uid' IN (:userIds)")
    fun loadAllByIds(userIds: IntArray?): List<User?>?

    @Query("SELECT * FROM User LIMIT 1")
    fun findUser(): User?

    @Insert
    fun insertAll(users: User?)

    @Delete
    fun delete(vararg users: User?)

    @Query("DELETE FROM User")
    fun deleteAllUser()
}

@Entity
data class User(
    var userName: String,

    var passWord: String
) {
    @PrimaryKey
    var id = 0

}