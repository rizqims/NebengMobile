package com.example.nebeng

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inpHP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inp_hp)

        supportActionBar?.hide()
        val userbtn : Button = findViewById(R.id.btn_masukdua)
        userbtn.setOnClickListener{
            val Intent = Intent(this, OTPVerfActivity::class.java)
            startActivity(Intent)
        }
    }
}