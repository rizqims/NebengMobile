package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NebengM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nebeng_m)
        supportActionBar?.hide()

        val userbtn : Button = findViewById(R.id.NebengProceed)
        userbtn.setOnClickListener{
            val Intent = Intent(this, NebengProceed::class.java)
            startActivity(Intent)
        }
    }
}