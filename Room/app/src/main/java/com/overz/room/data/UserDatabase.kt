package com.overz.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        private var instance: UserDatabase? = null
        fun getInstance(context: Context):UserDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "userInfo.db"
                ).allowMainThreadQueries().build()
            }
            return instance as UserDatabase
        }
    }
}