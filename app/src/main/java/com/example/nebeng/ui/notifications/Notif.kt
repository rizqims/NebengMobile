package com.example.nebeng.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nebeng.Editprofil
import com.example.nebeng.R
import com.example.nebeng.helper.PreferencesHelper

class Notif : AppCompatActivity() {
    lateinit var sharedpref : PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_notifications)
        sharedpref = PreferencesHelper(this)
        supportActionBar?.hide()

        val userbtn : Button = findViewById(R.id.editbtnn)
        userbtn.setOnClickListener{
            val Intent = Intent(this, Editprofil::class.java)
            startActivity(Intent)
        }
    }
}
