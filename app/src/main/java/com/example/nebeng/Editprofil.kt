package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nebeng.ui.notifications.NotificationsFragment

class Editprofil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofil)
        supportActionBar?.hide()


        //button back
        val btnBackProfile : Button = findViewById(R.id.backprofil)
        btnBackProfile.setOnClickListener{
            val Intent = Intent(this, NotificationsFragment::class.java)
            startActivity(Intent)
        }

    }
}