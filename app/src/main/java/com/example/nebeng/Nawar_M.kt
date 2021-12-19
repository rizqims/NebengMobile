package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Nawar_M : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nawar_m)
        supportActionBar?.hide()


        val userbtn : Button = findViewById(R.id.nawarproceed)
        userbtn.setOnClickListener{
            val Intent = Intent(this, NawarProceed::class.java)
            startActivity(Intent)
        }
    }
}