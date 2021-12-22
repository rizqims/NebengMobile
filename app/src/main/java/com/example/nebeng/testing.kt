package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class testing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        supportActionBar?.hide()

        val userbtn: Button = findViewById(R.id.gotoEdit)
        userbtn.setOnClickListener {
            val Intent = Intent(this, Editprofil::class.java)
            startActivity(Intent)
        }

        val userbtntu: Button = findViewById(R.id.gotoUtama)
        userbtntu.setOnClickListener {
            val Intent = Intent(this, HomeActivity::class.java)
            startActivity(Intent)
        }

        val userbtntri: Button = findViewById(R.id.gotoNebeng)
        userbtntri.setOnClickListener {
            val Intent = Intent(this, NebengM::class.java)
            startActivity(Intent)
        }

        val userbtnfour: Button = findViewById(R.id.gotoNawar)
        userbtnfour.setOnClickListener {
            val Intent = Intent(this, NawarActivity::class.java)
            startActivity(Intent)
        }


    }
}
