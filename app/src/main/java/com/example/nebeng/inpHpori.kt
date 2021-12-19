package com.example.nebeng

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class inpHpori : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inp_hp)

        supportActionBar?.hide()
//        val userbtn : Button = findViewById(R.id.btn_masuknomor)
//        userbtn.setOnClickListener{
//            val Intent = Intent(this, OTPVerfActivity::class.java)
//            startActivity(Intent)
//        }
    }
}
