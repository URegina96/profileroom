package com.example.profileroom

import com.example.profileroom.database.AppDatabase
import android.app.Application import androidx.room.Room

class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "my-database").build()
    }
}