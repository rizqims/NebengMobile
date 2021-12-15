package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        val userbtn : Button = findViewById(R.id.btn_masuk)
        userbtn.setOnClickListener{
            val Intent = Intent(this, inpHP::class.java)
            startActivity(Intent)
        }
    }
}