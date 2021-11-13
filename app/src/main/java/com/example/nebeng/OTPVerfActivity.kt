package com.example.nebeng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OTPVerfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        supportActionBar?.hide()
    }
}