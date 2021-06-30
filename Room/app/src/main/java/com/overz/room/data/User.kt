package com.overz.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "user_info_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id: Int,
    @ColumnInfo(name = "user_name")
    val username: String,
    val age: Int,
    @ColumnInfo(name = "sex")
    val gender:Boolean,
    @Ignore val city: String
)