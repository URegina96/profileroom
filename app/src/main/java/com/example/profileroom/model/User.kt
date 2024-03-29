package com.example.profileroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String,
    var age: Int,
    var email: String
)