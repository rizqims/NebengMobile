package com.example.nebeng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProgresNebeng : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progres_nebeng)
        supportActionBar?.hide()
        
        val a : TextView = findViewById(R.id.asw)
        a.setText("mama").toString()

    }
}