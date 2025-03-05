package com.example.loginapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var btnSave: Button
    private lateinit var tvGreeting: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        btnSave = findViewById(R.id.btnSave)
        tvGreeting = findViewById(R.id.tvGreeting)
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        val savedName = sharedPreferences.getString("username", "")
        if (savedName!!.isNotEmpty()) {
            tvGreeting.text = "Привет, $savedName!"
        }

        btnSave.setOnClickListener {
            val username = etUsername.text.toString()
            if (username.isNotEmpty()) {
                sharedPreferences.edit().putString("username", username).apply()
                tvGreeting.text = "Привет, $username!"
            }
        }
    }
}