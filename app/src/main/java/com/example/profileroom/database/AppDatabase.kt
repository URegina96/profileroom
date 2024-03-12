package com.example.profileroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.profileroom.dao.UserDao
import com.example.profileroom.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}