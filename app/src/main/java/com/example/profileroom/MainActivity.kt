package com.example.profileroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.profileroom.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()

        GlobalScope.launch(Dispatchers.IO) {
            val users = db.userDao().getAll() // Получить список всех пользователей из базы данных

            for (user in users) {
                val textViewName = findViewById<TextView>(R.id.textViewName)
                textViewName.text = user.name
                val textViewAge = findViewById<TextView>(R.id.textViewAge)
                textViewAge.text = user.age.toString()
                val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
                textViewEmail.text = user.email
            }
        }

        val buttonCreate = findViewById<Button>(R.id.buttonCreate)
        buttonCreate.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }
    }
}