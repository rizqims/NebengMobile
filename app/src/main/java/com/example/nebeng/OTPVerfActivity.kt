package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class OTPVerfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        supportActionBar?.hide()

        val userbtn : ImageButton = findViewById(R.id.btn_kirim)
        userbtn.setOnClickListener{
            val Intent = Intent(this, Beranda::class.java)
            startActivity(Intent)
        }
    }
}