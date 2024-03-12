package com.example.profileroom.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.profileroom.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)
}