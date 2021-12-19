package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class NebengProceed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nebeng_proceed)
        supportActionBar?.hide()

        val userbtn : Button = findViewById(R.id.Nebengok)
        userbtn.setOnClickListener{
            val Intent = Intent(this, ProgresNebeng::class.java)
            startActivity(Intent)
        }
    }
}