package com.example.profileroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import com.example.profileroom.database.AppDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()

        val buttonCreate = findViewById<Button>(R.id.buttonCreate)
        buttonCreate.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }
    }
}