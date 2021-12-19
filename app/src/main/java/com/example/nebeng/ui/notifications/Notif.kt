package com.example.nebeng.ui.notifications

import com.example.nebeng.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nebeng.Editprofil

class Notif : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_notifications)
        supportActionBar?.hide()

        val userbtn : Button = findViewById(R.id.editbtnn)
        userbtn.setOnClickListener{
            val Intent = Intent(this, Editprofil::class.java)
            startActivity(Intent)
        }
    }
}