package com.example.profileroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.room.Room
import com.example.profileroom.database.AppDatabase
import com.example.profileroom.model.User

class EditProfile : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()

        val buttonReturn = findViewById<Button>(R.id.buttonReturn)
        buttonReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextName).text.toString()
            val age = findViewById<EditText>(R.id.editTextAge).text.toString().toInt()
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()

            val user = User(name = name, age = age, email = email)

            GlobalScope.launch {
                db.userDao().insertUser(user)

                val duplicateIds = db.userDao().getDuplicateIds()
                if (duplicateIds.isNotEmpty()) {
                    // Найдены записи с повторяющимися id
                    for (id in duplicateIds) {
                        Log.d("DuplicateId", "Duplicate id: $id")
                    }
                } else {
                    // Нет записей с повторяющимися id
                    Log.d("DuplicateId", "No duplicate ids found")
                }
            }
        }
    }
}