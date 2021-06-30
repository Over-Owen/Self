package com.overz.roomoperatedatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * 用户信息 - 数据类.
 * <p>
 * 作为数据库中的用户信息-表，使用Room操作定义的数据库表，其中定义了数据表中的表名、列值属性、主键，
 * </p>
 */
//不加(tableName = "user_table")，则默认表名称为 User
@Entity(tableName = "user_table")
data class User(
    //设置默认主键，自动生成true
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val sex: Boolean
)
