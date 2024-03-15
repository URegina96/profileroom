package com.example.profileroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.profileroom.model.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM User")
    fun getAll(): List<User>
}