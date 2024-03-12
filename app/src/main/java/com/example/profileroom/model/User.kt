package com.example.profileroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int? = null,
    val name: String,
    val age: Int,
    val email: String
)